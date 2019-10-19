package com.believeyourself.leetcode.powerofFour;

/**
 * 342. Power of Four
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 *
 * Example 1:
 *
 * Input: 16
 * Output: true
 * Example 2:
 *
 * Input: 5
 * Output: false
 * Follow up: Could you solve it without loops/recursion?
 */
public class PowerofFour {


    /**
     * 利用循环法
     * @param num
     * @return
     */
    public boolean isPowerOfFour(int num) {
        if(num < 1){
            return false;
        }
        while (num % 4 == 0){
            num /= 4;
        }
        return num == 1;
    }

    /**
     * 利用4的power在二进制上的特性。
     * 4--> 0100
     * 3--> 0011
     * 0xa-->1011
     * @param num
     * @return
     */
    public boolean isPowerOfFour2(int num) {
        return num > 0 && (num &(num -1)) == 0 && (num & 0xaaaaaaaa) == 0;
    }
}
