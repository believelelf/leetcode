package com.believeyourself.leetcode.numberof1Bits;

/**
 * 191. Number of 1 Bits
 * Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
 * Example 2:
 * <p>
 * Input: 00000000000000000000000010000000
 * Output: 1
 * Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
 * Example 3:
 * <p>
 * Input: 11111111111111111111111111111101
 * Output: 31
 * Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 * <p>
 * <p>
 * Note:
 * <p>
 * Note that in some languages such as Java, there is no unsigned integer type. In this case, the input will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3 above the input represents the signed integer -3.
 * <p>
 * <p>
 * Follow up:
 * <p>
 * If this function is called many times, how would you optimize it?
 */
public class Numberof1Bits {

    /**
     * 解题思路：
     * 1. 使用位运算，进行位移处理。时间复杂度为O(n)
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            if (i < 31) {
                n >>>= 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Numberof1Bits().hammingWeight(-3));
    }
}
