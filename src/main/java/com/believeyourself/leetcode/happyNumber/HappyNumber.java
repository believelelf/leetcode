package com.believeyourself.leetcode.happyNumber;

/**
 * 202. Happy Number
 * Write an algorithm to determine if a number is "happy".
 * <p>
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * <p>
 * Example:
 * <p>
 * Input: 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class HappyNumber {

    /**
     * 解题思路：
     * 1.构建函数，对于数字进行余10除10运算，得每位数平方和
     * 2.对于循环中止条件进行判断，和为1，或出现了两个相同和的情况（类检测单链表是否有环，一个走二步，一个一步，判断是否存在值相同），
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        int oneStepSum = n;
        int twoStepSum = n;
        while (oneStepSum != 1) {
            // 移动1步
            oneStepSum = sum(oneStepSum);
            if(oneStepSum == 1){
                return true;
            }
            // 移动2步
            twoStepSum = sum(sum(twoStepSum));
            if(twoStepSum == 1){
                return true;
            }
            if(oneStepSum == twoStepSum){
                return false;
            }

        }
        return true;
    }

    public int sum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(19));
    }

}
