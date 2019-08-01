package com.believeyourself.leetcode.houseRobber;

/**
 * 198. House Robber
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 * <p>
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class HouseRobber {

    /**
     * 解题思路：
     * 1. 时间复杂度 O(n), 进行一次迭代，求截至当前下标时，本节点盗与不盗分两种情况。求得最大值。
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int robPrevSum = 0; // rob前house时的最大值
        int notRobPrevSum = 0; // 没有rob前house时最大值
        for (int i = 0; i < nums.length; i++) {
            int currRobSum = notRobPrevSum + nums[i]; // 盗当前house,则为前house不盗，再加当前house中amount
            int notRobCurrSum = Math.max(robPrevSum, notRobPrevSum); // 不盗当前house，则最大值取盗前house或不盗前house的大值
            notRobPrevSum = notRobCurrSum;
            robPrevSum = currRobSum;
        }
        return Math.max(robPrevSum, notRobPrevSum);
    }

    public static void main(String[] args) {
        System.out.println(new HouseRobber().rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(new HouseRobber().rob(new int[]{2, 1, 1, 2}));
    }
}
