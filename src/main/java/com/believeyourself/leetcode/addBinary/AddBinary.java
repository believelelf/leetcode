package com.believeyourself.leetcode.addBinary;

/**
 * 67. Add Binary
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * The input strings are both non-empty and contains only characters 1 or 0.
 * <p>
 * Example 1:
 * <p>
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * <p>
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class AddBinary {

    /**
     * 解题思路：
     * 1. 求得两个串最大长度
     * 2. 进行循环，从最低位开始进行二进制运算
     *
     * @param a 二进制串a
     * @param b 二进制串b
     * @return 相加后二进制串
     */
    public String addBinary(String a, String b) {
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        StringBuilder builder = new StringBuilder();
        int lastChar = 0;
        while (true) {
            char aChar = aIndex > -1 ? a.charAt(aIndex--) : '0';
            char bChar = bIndex > -1 ? b.charAt(bIndex--) : '0';
            int n = lastChar + aChar + bChar - 96;
            builder.append(n % 2);
            lastChar = n / 2;
            if (bIndex == -1 && aIndex == -1) {
                if(lastChar != 0){
                    builder.append(lastChar);
                }
                break;
            }
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("11", "1"));
        System.out.println(new AddBinary().addBinary("1010", "1011"));
    }

}
