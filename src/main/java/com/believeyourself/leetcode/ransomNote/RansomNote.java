package com.believeyourself.leetcode.ransomNote;

/**
 * 383. Ransom Note
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class RansomNote {

    /**
     * 解题思路：
     * 先对magazine构建一个字典表，再遍历ransomNote，看其对应字符是否有出现，并出现的次数小于manazine中的次数。
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] table = new int[26];
        for(char c : magazine.toCharArray()){
            table[c - 'a']++;
        }
        for(char c : ransomNote.toCharArray()){
            if(--table[c - 'a'] < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new RansomNote().canConstruct("a", "b"));
        System.out.println(new RansomNote().canConstruct("aa", "ab"));
        System.out.println(new RansomNote().canConstruct("aa", "aab"));
    }
}
