package com.believeyourself.leetcode.reverseVowelsofaString;

/**
 * 345. Reverse Vowels of a String
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1:
 *
 * Input: "hello"
 * Output: "holle"
 * Example 2:
 *
 * Input: "leetcode"
 * Output: "leotcede"
 * Note:
 * The vowels does not include the letter "y".
 */
public class ReverseVowelsofaString {

    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        char[] ss = s.toCharArray();
        int lo = 0;
        int hi = s.length() - 1;
        while(lo < hi){
            // 移动低位指针
            while(lo < hi && vowels.indexOf(ss[lo]) == -1){
                lo++;
            }
            // 移动高位指针
            while(lo < hi && vowels.indexOf(ss[hi]) == -1){
                hi--;
            }
            // 交换
            char temp = ss[lo];
            ss[lo] = ss[hi];
            ss[hi] = temp;

            lo++;
            hi--;
        }

        return new String(ss);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseVowelsofaString().reverseVowels("hello"));
        System.out.println(new ReverseVowelsofaString().reverseVowels("leetcode"));
    }
}
