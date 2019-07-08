package com.believeyourself.leetcode.longestCommonPrefix;

/**
 * 14. Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 * <p>
 * All given inputs are in lowercase letters a-z.
 */
public class LongestCommonPrefix {

    /**
     * 解题思路：
     * 1. 以第一个字符串进行倒数截取子串，先求第一和第二个字符串的公共子串，再扩展到所有字符串
     *
     * @param strs 字符串数组
     * @return 最长公共子串
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (!strs[i].startsWith(prefix)) {
                //  先求得两个字符串的最长公共前缀
                prefix = prefix.substring(0, prefix.length() - 1);
            }
            if ("".equals(prefix)) {
                break;
            }
            i++;
        }
        return prefix;
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
}
