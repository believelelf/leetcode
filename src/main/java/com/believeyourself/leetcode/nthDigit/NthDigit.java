package com.believeyourself.leetcode.nthDigit;

/**
 * 400. Nth Digit
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 *
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n < 231).
 *
 * Example 1:
 *
 * Input:
 * 3
 *
 * Output:
 * 3
 * Example 2:
 *
 * Input:
 * 11
 *
 * Output:
 * 0
 *
 * Explanation:
 * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 */
public class NthDigit {

    /**
     * 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
     * 解题思路：
     * 1.定义一个变量，代表数字的位数a,从1开始增加，1-9为一位(9个数)，10-99为两位（90个数）。100-999为三位（900个数）...
     * 2. 则n值每减过一次循环应减少9 * 10 ^(a- 1),如减少此值后大于0,再循环继续，否则将不减此值，将n / a作为增加数，n%a,作为某个数的位数。
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        if(n < 10){
            return  n;
        }
        // 求得数值所在范围
        int a = 1;
        double range;
        while(n > (range = a * 9 * Math.pow(10d, (a -1)))){
            n -= range;
            a++;
        }
        int quotient = n / a;
        int remainder = n % a;
        // 取对应的数值
        int num = (int)(Math.pow(10d, (a - 1)) - 1) + quotient;
        if(remainder > 0){
            num++;
        }
        // 对余数进行校正
        remainder = remainder == 0 ? a -1 : remainder -1;
        return Integer.valueOf(String.valueOf(String.valueOf(num).charAt(remainder)));
    }

    public static void main(String[] args) {
        System.out.println(new NthDigit().findNthDigit(3));
        System.out.println(new NthDigit().findNthDigit(11));
        System.out.println(new NthDigit().findNthDigit(12));
        System.out.println(new NthDigit().findNthDigit(13));
        System.out.println(new NthDigit().findNthDigit(14));
        System.out.println(new NthDigit().findNthDigit(15));
    }
}
