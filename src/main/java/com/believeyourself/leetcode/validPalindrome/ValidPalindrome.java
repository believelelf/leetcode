package com.believeyourself.leetcode.validPalindrome;

/**
 * 125. Valid Palindrome
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 * <p>
 * Input: "race a car"
 * Output: false
 */
public class ValidPalindrome {

    /**
     * 解题思路：
     * 1. 维护两个下标，一个从前向后增长，一个从后向前增长。
     * 2. 如果相同两个下标（排除非数字及字母后）的值不同，则非回文。
     *
     * @param s 输入字符串
     * @return 是否相符
     */
    public boolean isPalindrome(String s) {
        int index = 0;
        int lastIndex = s.length() -1;
        while (index < lastIndex){
            char c = s.charAt(index++);
            boolean isUpper = false;
            while(!isNumber(c) && !isLowercase(c) && !(isUpper = isUppercase(c))){
                if(index > lastIndex){
                    return true;
                }
                c = s.charAt(index++);
            }
            if(isUpper){
                c = lowercase(c);
            }
            char lc = s.charAt(lastIndex--);
            isUpper = false;
            while(!isNumber(lc) && !isLowercase(lc) && !(isUpper = isUppercase(lc))){
                if(index > lastIndex){
                    return true;
                }
                lc = s.charAt(lastIndex--);
            }
            if(isUpper){
                lc = lowercase(lc);
            }
            if(lc != c){
                return false;
            }
        }
        return true;
    }

    public boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public boolean isLowercase(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    public boolean isUppercase(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }

    public char lowercase(char ch){
        return (char) ('a' + (ch - 'A'));
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new ValidPalindrome().isPalindrome("race a car"));
    }


}
