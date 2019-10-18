package com.believeyourself.leetcode.missingNumber;

/**
 * 268. Missing Number
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * Example 1:
 *
 * Input: [3,0,1]
 * Output: 2
 * Example 2:
 *
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class MissingNumber {

    /**
     * 解题思路：
     * 利用a ^ b ^ b = a
     * 下标：[0, n-1]
     * 数值：[0 ~ n]
     * 利XOR特性可以求得缺少的数值
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int xor = nums.length;
        for(int i = 0; i < nums.length; i++){
            xor = xor ^ i ^ nums[i];
        }
        return xor;
    }

    public static void main(String[] args) {
        System.out.println(new MissingNumber().missingNumber(new int[]{3,0,1}));
        System.out.println(new MissingNumber().missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }
}
