package com.believeyourself.leetcode.minCostClimbingStairs;

/**
 * 746. Min Cost Climbing Stairs
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 *
 * Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.
 *
 * Example 1:
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 * Example 2:
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 * Note:
 * cost will have a length in the range [2, 1000].
 * Every cost[i] will be an integer in the range [0, 999].
 */
public class MinCostClimbingStairs {

    /**
     * 解决思路：
     * 使用动态规划来解决此问题。
     * 爬上第n级台阶的最小花费，相当于爬上n-1级的最小花费和爬上n-2级的最小花费之中的小值，再加第n级所需的花费。
     * 其状态转移方程为：
     * 若 n > 2, f(n) = min(f(n-1), f(n-2)) + cost[i];
     * f(1) =cost[0]; f(2) = cost[1];
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int f1 = cost[0];
        int f2 = cost[1];
        for(int i = 2; i < cost.length; i++){
            int current = Math.min(f1, f2) + cost[i];
            f1 = f2;
            f2 = current;
        }
        return Math.min(f1, f2);
    }

    public static void main(String[] args) {
        int[] cost = new int[]{10, 15, 20};
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(cost));

        cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(cost));

    }
}
