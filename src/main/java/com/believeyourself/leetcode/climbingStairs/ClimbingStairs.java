package com.believeyourself.leetcode.climbingStairs;

/**
 * 70. Climbing Stairs
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class ClimbingStairs {

    /**
     * 解题思路：
     * 1.对于指定n存在对应位和前一位的和为下一位的值
     *
     * @param n 级数
     * @return 组合数
     */
    public int climbStairs(int n) {
        if(n < 3){
            return n;
        }
        int answer = 3;
        int last = 2;
        int nextToLast = 1;
        for (int i = 3; i <= n; i++) {
            answer = last + nextToLast;
            nextToLast = last;
            last = answer;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(2));
        System.out.println(new ClimbingStairs().climbStairs(3));
        System.out.println(new ClimbingStairs().climbStairs(4));
        System.out.println(new ClimbingStairs().climbStairs(5));
    }

}
