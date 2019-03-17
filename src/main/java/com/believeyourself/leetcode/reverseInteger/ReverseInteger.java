/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * Input: 123
 * Output: 321
 * <p>
 * Example 2:
 * Input: -123
 * Output: -321
 * <p>
 * Example 3:
 * Input: 120
 * Output: 21
 * <p>
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
package com.believeyourself.leetcode.reverseInteger;

public class ReverseInteger {

    public int reverse(int x) {
        int retVal = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            // check overflow
            // Integer.MAX_VALUE= 2147483647
            if (retVal > Integer.MAX_VALUE / 10 || (retVal == Integer.MAX_VALUE && pop > 7)) {
                return 0;
            }
            // Integer.MIN_VALUE= -2147483648
            if (retVal < Integer.MIN_VALUE / 10 || (retVal == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            retVal = retVal * 10 + pop;
        }
        return retVal;
    }

}
