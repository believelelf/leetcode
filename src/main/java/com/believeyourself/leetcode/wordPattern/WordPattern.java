package com.believeyourself.leetcode.wordPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. Word Pattern
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 *
 * Example 1:
 *
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * Example 2:
 *
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * Example 3:
 *
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * Example 4:
 *
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
 */
public class WordPattern {


    /**
     * 要注意两个方向都要判断，如Example 4
     * @param pattern
     * @param str
     * @return
     */
    public boolean wordPattern(String pattern, String str) {
        if(pattern == null || str == null){
            return false;
        }
        char [] patterns = pattern.toCharArray();
        String[] strs = str.split(" ");
        if(patterns.length!= strs.length){
            return false;
        }
        Map<Character, String> char2Str = new HashMap<>();
        Map<String, Character> str2Char = new HashMap<>();
        for(int i = 0; i < patterns.length; i++){
            if(char2Str.containsKey(patterns[i])){
                if(!char2Str.get(patterns[i]).equals(strs[i])){
                    return false;
                }
            }else{
                if(str2Char.containsKey(strs[i])){
                    return false;
                }
                char2Str.put(patterns[i], strs[i]);
                str2Char.put(strs[i], patterns[i]);
            }
        }
        return true;
    }
}
