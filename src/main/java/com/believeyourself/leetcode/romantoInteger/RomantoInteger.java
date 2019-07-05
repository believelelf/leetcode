package com.believeyourself.leetcode.romantoInteger;

/**
 * 13. Roman to Integer
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * Example 1:
 * <p>
 * Input: "III"
 * Output: 3
 * Example 2:
 * <p>
 * Input: "IV"
 * Output: 4
 * Example 3:
 * <p>
 * Input: "IX"
 * Output: 9
 * Example 4:
 * <p>
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 5:
 * <p>
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class RomantoInteger {

    /**
     * 解题思路：
     * 1. 依次迭代s,如果前后两个字符不一致，且非subtraction，进行次数累乘。如为subtraction取特别值。
     *
     * @param s 入参
     * @return 转换数值
     */
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int ret = 0;
        for (int i = 0, length = chars.length; i < length; i++) {
            char c = chars[i];
            switch (c) {
                case 'M':
                    ret += 1000;
                    break;
                case 'D':
                    ret += 500;
                    break;
                case 'C':
                    if (i < length - 1) {
                        if (chars[i + 1] == 'M') {
                            ret += 900;
                            i++;
                            break;
                        } else if (chars[i + 1] == 'D') {
                            ret += 400;
                            i++;
                            break;
                        }
                    }
                    ret += 100;
                    break;
                case 'L':
                    ret += 50;
                    break;
                case 'X':
                    if (i < length - 1) {
                        if (chars[i + 1] == 'C') {
                            ret += 90;
                            i++;
                            break;
                        } else if (chars[i + 1] == 'L') {
                            ret += 40;
                            i++;
                            break;
                        }
                    }
                    ret += 10;
                    break;
                case 'V':
                    ret += 5;
                    break;
                default:
                    // I
                    if (i < length - 1) {
                        if (chars[i + 1] == 'X') {
                            ret += 9;
                            i++;
                            break;
                        } else if (chars[i + 1] == 'V') {
                            ret += 4;
                            i++;
                            break;
                        }
                    }
                    ret += 1;
                    break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new RomantoInteger().romanToInt("III"));
        System.out.println(new RomantoInteger().romanToInt("IV"));
        System.out.println(new RomantoInteger().romanToInt("IX"));
        System.out.println(new RomantoInteger().romanToInt("LVIII"));
        System.out.println(new RomantoInteger().romanToInt("MCMXCIV"));
    }
}
