package com.believeyourself.leetcode.toLowerCase;

/**
 * 709. To Lower Case
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 * <p>
 * Example 1:
 * <p>
 * Input: "Hello"
 * Output: "hello"
 * Example 2:
 * <p>
 * Input: "here"
 * Output: "here"
 * Example 3:
 * <p>
 * Input: "LOVELY"
 * Output: "lovely"
 */
public class ToLowerCase {

    public String toLowerCase(String str) {
        int len = str.length();
        char[] ret = new char[len];
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if(ch>='A' && ch <='Z'){
                ch = lowerCase(ch);
            }
            ret[i] = ch;
        }
        return String.valueOf(ret);
    }

    public char lowerCase(char ch) {
        return (char) ('a' + ch - 'A');
    }

    public static void main(String[] args) {
        System.out.println(new ToLowerCase().toLowerCase("Hello"));
    }
}
