package com.believeyourself.leetcode.factorialTrailingZeroes;

/**
 * 172. Factorial Trailing Zeroes
 * Given an integer n, return the number of trailing zeroes in n!.
 * <p>
 * Example 1:
 * <p>
 * Input: 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * Example 2:
 * <p>
 * Input: 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * Note: Your solution should be in logarithmic time complexity.
 */
public class FactorialTrailingZeroes {

    /**
     * 解题思路：
     * 1. 在阶乘中如果结尾中出现0，则数字中要出现5， 满足2 * 5 = 10, n个5，出现n个0
     * 示例：
     * 1 2 3 4 5
     * ==》
     * 120
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

    public static void main(String[] args) {
        System.out.println(new FactorialTrailingZeroes().trailingZeroes(3));
        System.out.println(new FactorialTrailingZeroes().trailingZeroes(5));
    }
}
