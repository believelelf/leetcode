package com.believeyourself.leetcode.firstUniqueCharacterinaString;

/**
 * 387. First Unique Character in a String
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqueCharacterinaString {

    /**
     * 构建字典表，再查表次数
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        int[] table = new int[26];
        for(char c : s.toCharArray()){
            table[c - 'a']++;
        }
        for(int i = 0, len = s.length(); i < len; i++){
            if(table[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}
