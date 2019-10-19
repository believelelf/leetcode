package com.believeyourself.leetcode.reverseString;

import java.util.Arrays;

/**
 * 344. Reverse String
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * You may assume all the characters consist of printable ascii characters.
 *
 *
 *
 * Example 1:
 *
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 *
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 */
public class ReverseString {

    public void reverseString(char[] s) {
        int lo = 0;
        int hi = s.length -  1;
        while (lo < hi){
            char temp = s[lo];
            s[lo] = s[hi];
            s[hi] = temp;
            lo++;
            hi--;
        }
    }

    public static void main(String[] args) {
        char[] s = new char[]{'H','a','n','n','a','h'};
        new ReverseString().reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}
