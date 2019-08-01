package com.believeyourself.leetcode.countPrimes;

/**
 * 204. Count Primes
 * Count the number of prime numbers less than a non-negative number, n.
 * <p>
 * Example:
 * <p>
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class CountPrimes {

    /**
     * 解题思路：
     * 1. 只能被自身或1整除的为质数
     * 2. 循环遍历，直到数字增长到n,构建一个数组，用于保存当前位是否为质数，在当前位的基础上，再次进行遍历，存在两个数的乘积均为非质数。
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        int count = 0;
        // 保存直到n的数列，各位是否为非质数
        // 2-->非质数
        // 3-->非质数
        boolean[] notPrimes = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!notPrimes[i]) {
                count++;
                // 如果当前位为质数，再求后续两数和是否为质数
                for (int j = 2; j * i < n; j++) {
                    notPrimes[j * i] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new CountPrimes().countPrimes(10));
    }
}
