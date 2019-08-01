package com.believeyourself.leetcode.excelSheetColumnTitle;

/**
 * 168. Excel Sheet Column Title
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * <p>
 * For example:
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 * Example 1:
 * <p>
 * Input: 1
 * Output: "A"
 * Example 2:
 * <p>
 * Input: 28
 * Output: "AB"
 * Example 3:
 * <p>
 * Input: 701
 * Output: "ZY"
 */
public class ExcelSheetColumnTitle {
    /**
     * 解题思路：
     * 1.将十进制转换为二十六进制
     *
     * @param n
     * @return
     */
    public String convertToTitle(int n) {

        StringBuilder builder = new StringBuilder();
        int quotient;
        do {
            n--;
            quotient = n / 26;
            int residue = n % 26;
            builder.insert(0, (char) (residue + 'A'));
            n = quotient;
        } while (quotient != 0);
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(1));
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(28));
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(701));
    }
}
