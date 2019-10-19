package com.believeyourself.leetcode.rangeSumQueryImmutable;

/**
 * 303. Range Sum Query - Immutable
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 */
public class NumArray {



    /* 用于保存每个下标之前所有数的和*/
    private int[] sums;
    /**
     * 动态规划：
     * 将两个下标i,j的之间的数的和，转换为sum[0...j]-sum[0...i-1].如
     * sum[2...5] = sum[0...5]-sum[0..1]
     * 通过构建sum[],再保存各个下标位的和，最后做减法。
     *
     * @param nums
     */
    public NumArray(int[] nums) {
        sums = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}
