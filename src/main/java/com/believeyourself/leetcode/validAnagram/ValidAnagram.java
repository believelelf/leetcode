package com.believeyourself.leetcode.validAnagram;

/**
 * 242. Valid Anagram
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * <p>
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class ValidAnagram {
    /**
     * Anagra：相同字母异序词
     * 解题思路：
     * 构建一个字符表，比较每一个字符出现的次数
     */
    public boolean isAnagram(String s, String t) {
        int[] sTable = new int[26];
        int[] tTable = new int[26];
        for (char c : s.toCharArray()) {
            sTable[c - 'a']++;
        }
        for(char c : t.toCharArray()){
            tTable[c - 'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(sTable[i] != tTable[i]){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new ValidAnagram().isAnagram("anagram", "nagaram"));
        System.out.println(new ValidAnagram().isAnagram("rat", "car"));
    }
}
