package com.believeyourself.leetcode.validPerfectSquare;

/**
 * 367. Valid Perfect Square
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Note: Do not use any built-in library function such as sqrt.
 *
 * Example 1:
 *
 * Input: 16
 * Output: true
 * Example 2:
 *
 * Input: 14
 * Output: false
 */
public class ValidPerfectSquare {

    /**
     * 利用二分法对num进行折半向下缩小，求得mid * mid = num.
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        int lo = 1;
        int hi = num;
        while(lo <= hi){
            long mid = (lo + hi) / 2;
            if(mid * mid == num){
                return true;
            }else if(mid * mid < num){
                lo = (int)mid + 1;
            }else {
                hi = (int)mid - 1;
            }
        }
        return false;
    }

    /**
     * 利用一个数的平方可以拆解为1+3+5+7...特性，进行递减。
     * @param num
     * @return
     */
    public boolean isPerfectSquare2(int num){
        int i = 1;
        while(num > 0){
            // 依次减1,3,5...
            num -= i;
            i +=2;
        }
        return num == 0;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPerfectSquare().isPerfectSquare(16));
        System.out.println(new ValidPerfectSquare().isPerfectSquare(5));
        System.out.println(new ValidPerfectSquare().isPerfectSquare(1));
        System.out.println(new ValidPerfectSquare().isPerfectSquare(14));
    }
}
