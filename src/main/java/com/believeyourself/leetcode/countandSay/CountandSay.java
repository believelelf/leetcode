package com.believeyourself.leetcode.countandSay;

/**
 * 38. Count and Say
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * <p>
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 * <p>
 * Note: Each term of the sequence of integers will be represented as a string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: "1"
 * Example 2:
 * <p>
 * Input: 4
 * Output: "1211"
 * Accepted
 * <p>
 * 初始值第一行是 1。
 * 第二行读第一行，1 个 1，去掉个字，所以第二行就是 11。
 * 第三行读第二行，2 个 1，去掉个字，所以第三行就是 21。
 * 第四行读第三行，1 个 2，1 个 1，去掉所有个字，所以第四行就是 1211。
 * 第五行读第四行，1 个 1，1 个 2，2 个 1，去掉所有个字，所以第五航就是 111221。
 * 第六行读第五行，3 个 1，2 个 2，1 个 1，去掉所以个字，所以第六行就是 312211。
 * 然后题目要求输入 1 - 30 的任意行数，输出该行是啥。
 */
public class CountandSay {

    /**
     * 解题思路：
     * 1. 采用递归
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String say = countAndSay(n - 1);
        StringBuilder builder = new StringBuilder();
        char[] chars = say.toCharArray();
        for (int i = 0, length = chars.length; i < length; i++) {
            int count = 1;
            while (i < length - 1 && chars[i] == chars[i + 1]) {
                count++;
                i++;
            }
            builder.append(count).append(chars[i]);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new CountandSay().countAndSay(1));
        System.out.println(new CountandSay().countAndSay(2));
        System.out.println(new CountandSay().countAndSay(3));
        System.out.println(new CountandSay().countAndSay(4));
        System.out.println(new CountandSay().countAndSay(5));
    }
}
