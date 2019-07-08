package com.believeyourself.leetcode.implementStrStr;

/**
 * 28. Implement strStr()
 * Implement strStr().
 * <p>
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * <p>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 * <p>
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 * <p>
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * <p>
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */
public class ImplementstrStr {
    /**
     * 解题思路：
     * 1. 先进行特定值处理
     * 2. 维护两个指针，第一个指针维护子串起始下标，第二个指针维护子串偏移值
     *
     * @param haystack 字符串
     * @param needle   指定串
     * @return 起始下标
     */
    public int strStr(String haystack, String needle) {
        if (haystack == null
                || needle == null
                || haystack.length() < needle.length()) {
            return -1;
        }
        if ("".equals(needle)) {
            return 0;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int nIndex = 0;
            while (needle.charAt(nIndex)== haystack.charAt(i + nIndex)) {
                nIndex++;
                if (nIndex == needle.length()) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new ImplementstrStr().strStr("hello", "ll"));
        System.out.println(new ImplementstrStr().strStr("aaaaa", "bba"));
        System.out.println(new ImplementstrStr().strStr("aaaaa", ""));
        System.out.println(new ImplementstrStr().strStr("aaaaa", "aaaaaa"));
        System.out.println(new ImplementstrStr().strStr("aaaaa", "aaaaa"));
    }

}
