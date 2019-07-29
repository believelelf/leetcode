package com.believeyourself.leetcode.singleNumber;

/**
 * 136. Single Number
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * <p>
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [4,1,2,1,2]
 * Output: 4
 */
public class SingleNumber {

    /**
     * 解题思路：
     * 1. 使用位运算 ^(XOR)的特性，两个相同的数进行XOR值为0，0与一个数进行异或运算值为此数，0 XOR A = A
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(4 ^ 0);
        System.out.println(2 ^ 2);
        System.out.println(new SingleNumber().singleNumber(new int[]{2, 2, 1}));
        System.out.println(new SingleNumber().singleNumber(new int[]{4, 1, 2, 1, 2}));
    }
}
