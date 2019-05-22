package com.believeyourself.leetcode.jewelsandStones;

/**
 * 771. Jewels and Stones
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 * <p>
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
 * <p>
 * Example 1:
 * <p>
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * Example 2:
 * <p>
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * Note:
 * <p>
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 */
public class JewelsandStones {

    /**
     * 解题思路：
     * 1. 构建一个两个数组byte[],用于放置S中不同的字符及S每个字符对应的次数。遍历S构建数组
     * 2. 再遍历J取出对应字母和。
     *
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        byte[] lowerChars = new byte[26];
        byte[] upperChars = new byte[26];
        for (int i = 0, len = S.length(); i < len; i++) {
            char ch = S.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                lowerChars[ch - 'a']++;
                continue;
            }
            if (ch >= 'A' && ch <= 'Z') {
                upperChars[ch - 'A']++;
            }
        }
        int count = 0;
        for (int i = 0, len = J.length(); i < len; i++) {
            char ch = J.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                count += lowerChars[ch - 'a'];
                continue;
            }
            if (ch >= 'A' && ch <= 'Z') {
                count += upperChars[ch - 'A'];
            }
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(new JewelsandStones().numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(new JewelsandStones().numJewelsInStones("z", "ZZ"));
    }

}
