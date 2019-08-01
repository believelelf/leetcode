package com.believeyourself.leetcode.excelSheetColumnNumber;

/**
 * 171. Excel Sheet Column Number
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * <p>
 * For example:
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * Example 1:
 * <p>
 * Input: "A"
 * Output: 1
 * Example 2:
 * <p>
 * Input: "AB"
 * Output: 28
 * Example 3:
 * <p>
 * Input: "ZY"
 * Output: 701
 */
public class ExcelSheetColumnNumber {

    /**
     * 解题思路：
     * 1. 将二六进制转换为十进制
     *
     * @param s
     * @return
     */
    public int titleToNumber(String s) {
        int length = s.length();
        int number = 0;
        for (int i = length - 1; i >= 0; i--) {
            char title = s.charAt(i);
            number += (title - 'A' + 1) * Math.pow(26, length - 1 - i);
        }
        return number;
    }

    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnNumber().titleToNumber("A"));
        System.out.println(new ExcelSheetColumnNumber().titleToNumber("AB"));
        System.out.println(new ExcelSheetColumnNumber().titleToNumber("ZY"));
    }
}
