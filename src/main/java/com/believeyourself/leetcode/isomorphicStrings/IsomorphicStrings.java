package com.believeyourself.leetcode.isomorphicStrings;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. Isomorphic Strings
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 * <p>
 * Input: s = "paper", t = "title"
 * Output: true
 * Note:
 * You may assume both s and t have the same length.
 */
public class IsomorphicStrings {

    /**
     * 解题思路：
     * 1. 构建两个map,匹配s和t字符出现的下标,比较两个char的value值是否相等。
     * 2.   key-> s.char;  value->s.index,
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        if (s == null || s.length() < 1) {
            return true;
        }
        // 构建两个map,比较字符串中char第一次出现value
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sKey = s.charAt(i);
            char tKey = t.charAt(i);
            int sValue = sMap.getOrDefault(sKey, -1);
            int tValue = tMap.getOrDefault(tKey, -1);
            if(sValue != tValue){
                return false;
            }
            sMap.put(sKey, i);
            tMap.put(tKey, i);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsomorphicStrings().isIsomorphic("egg", "add"));
        System.out.println(new IsomorphicStrings().isIsomorphic("egt", "add"));
    }
}
