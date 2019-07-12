package com.believeyourself.leetcode.plusOne;

import java.util.Arrays;

/**
 * 66. Plus One
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * <p>
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 * <p>
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */
public class PlusOne {


    /**
     * 解决思路：
     * 1. 对数组进行倒序迭代，最后一位加1后的值对10进行取余运算，余数在为当前位，商累加到前一位。
     * 2. 当前迭代到最高位后，如还存在商累加，则扩展数组1位，copy数据。
     *
     * @param digits 数组
     * @return 新的数组
     */
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        if (length == 1) {
            if (digits[0] < 9) {
                digits[0] = digits[0] + 1;
                return digits;
            }
            return new int[]{1, 0};
        }
        int val = digits[length - 1] + 1;
        digits[length - 1] = val % 10;
        int nextVal = val / 10;
        for (int i = digits.length - 2; i >= 0; i--) {
            val = digits[i] + nextVal;
            digits[i] = val % 10;
            nextVal = val / 10;
            if (i == 0 && nextVal > 0) {
                int[] ret = new int[length + 1];
                ret[0] = nextVal;
                System.arraycopy(digits, 0, ret, 1, digits.length);
                return ret;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{9, 9, 9})));
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{1})));
    }
}
