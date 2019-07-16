package com.believeyourself.leetcode.sqrt;

/**
 * 69. Sqrt(x)
 * Implement int sqrt(int x).
 * <p>
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * <p>
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 * <p>
 * Example 1:
 * <p>
 * Input: 4
 * Output: 2
 * Example 2:
 * <p>
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 * the decimal part is truncated, 2 is returned.
 */
public class Sqrt {

    /**
     * 解题思路：
     * 1. 利用二分查找，查找1...x对应的有序序列，取到mid*mid =x
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int sq = x / mid;
            if (mid == sq) {
                return mid;
            }
            if (mid < sq) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        System.out.println(new Sqrt().mySqrt(4));
        System.out.println(new Sqrt().mySqrt(8));
    }
}
