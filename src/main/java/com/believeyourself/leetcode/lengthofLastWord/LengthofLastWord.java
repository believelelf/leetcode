package com.believeyourself.leetcode.lengthofLastWord;

/**
 * 58. Length of Last Word
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * <p>
 * If the last word does not exist, return 0.
 * <p>
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * <p>
 * Example:
 * <p>
 * Input: "Hello World"
 * Output: 5
 */
public class LengthofLastWord {

    /**
     * 解题思路：
     * 1.）利用正则表达式解决此问题。
     * 2.）定义一个长度计数，循环迭代s,时间复杂度O(n)
     *
     * @param s 入参
     * @return 最后一个word的长度
     */
    public int lengthOfLastWord(String s) {
        int count = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                if (i == 0 || s.charAt(i - 1) == ' ') {
                    count = 1;
                } else {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new LengthofLastWord().lengthOfLastWord("Hello World"));
        System.out.println(new LengthofLastWord().lengthOfLastWord("Hello World  "));
        System.out.println(new LengthofLastWord().lengthOfLastWord("  "));
        System.out.println(new LengthofLastWord().lengthOfLastWord("sss  "));
    }
}
