package com.believeyourself.leetcode.maximumSubarray;

/**
 * 53. Maximum Subarray
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * <p>
 * Example:
 * <p>
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 * <p>
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubarray {

    /**
     * 解题思路：
     * 1. 将当前问题化解为求maxSubVal(...n) = maxSubVal(...n-1) >0 ? maxSubVal(...n-1)+nums[i] : nums[i]+0;
     *
     * @param nums 入参
     * @return 最大子序列和
     */
    public int maxSubArray(int[] nums) {
        // 截止上一个数的最大子序列和
        int lastNum = nums[0];
        int max = nums[0];
        if (nums.length == 1) {
            return max;
        }
        for (int i = 1; i < nums.length; i++) {
            lastNum = lastNum < 0 ? nums[i] : nums[i] + lastNum;
            max = Math.max(max, lastNum);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSubarray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

}
