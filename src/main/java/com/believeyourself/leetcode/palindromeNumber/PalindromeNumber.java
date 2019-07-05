package com.believeyourself.leetcode.palindromeNumber;

/**
 * 9. Palindrome Number
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * Example 1:
 * <p>
 * Input: 121
 * Output: true
 * Example 2:
 * <p>
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * <p>
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Follow up:
 * <p>
 * Coud you solve it without converting the integer to a string?
 */
public class PalindromeNumber {

    /**
     * 解题思路：
     * 1. 将负数排除
     * 2. 将入参x对10取余，反转x
     * 3. 比较结果与x是否相等
     *
     * @param x 入参
     * @return 反转后的值
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int ret = 0;
        int input = x;
        int residue;// 余数
        do {
            residue = x % 10;
            ret = ret * 10 + residue;
            x = x / 10;
        } while (x != 0);
        return ret == input;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeNumber().isPalindrome(121));
        System.out.println(new PalindromeNumber().isPalindrome(-121));
        System.out.println(new PalindromeNumber().isPalindrome(10));
        System.out.println(new PalindromeNumber().isPalindrome(9));
        System.out.println(new PalindromeNumber().isPalindrome(0));
    }

}
