package com.believeyourself.leetcode.powerofTwo;

/**
 * 231. Power of Two
 * Given an integer, write a function to determine if it is a power of two.
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: true
 * Explanation: 2^0 = 1
 * <p>
 * Example 2:
 * <p>
 * Input: 16
 * Output: true
 * Explanation: 2^4 = 16
 * <p>
 * Example 3:
 * <p>
 * Input: 218
 * Output: false
 */
public class PowerofTwo {

    public boolean isPowerOfTwo(int n) {
        return (n > 0) && (n & -n) == n;
    }

    public static void main(String[] args) {
        System.out.println(new PowerofTwo().isPowerOfTwo(0));
        System.out.println(new PowerofTwo().isPowerOfTwo(1));
        System.out.println(new PowerofTwo().isPowerOfTwo(3));
        System.out.println(new PowerofTwo().isPowerOfTwo(4));
        System.out.println(new PowerofTwo().isPowerOfTwo(-16));
    }
}
