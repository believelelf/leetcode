package com.believeyourself.leetcode.reverseInteger;

/**
 * @author wubai
 * @date 2019/3/18 22:11
 */
public class ReverseIntegerV1 {

    /**
     * Given a 32-bit signed integer, reverse digits of an integer.
     * <p>
     * Example 1:
     * <p>
     * Input: 123
     * Output: 321
     * <p>
     * Example 2:
     * <p>
     * Input: -123
     * Output: -321
     * <p>
     * Example 3:
     * <p>
     * Input: 120
     * Output: 21
     * Note:
     * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
     * <p>
     * 解题思路：
     * 1.检查输入值是否为0，如为0直接返回
     * 2.初始化返回值ret=0，在循环中，将输入值x进行除余处理，得到最小位pop，定义返回值为ret= ret*10 + pop,从而反转小位，处理下次输入值x = x/10, 从而去高位，循环结束条件定义为x != 0;
     * 3.在循环中且赋值返回值前最大值Integer.MAX_VALUE及Integer.MIN_VALUE的越界问题，此时比较关系缩小了10位。
     * ret > Integer.MAX_VALUE / 10 || 临界值 ret * 10 + pop + 1 = Integer.MAX_VALUE--> ret == Integer.MAX_VALUE(2147483647)/10（去除个位） && pop > 7
     * ret <  Integer.MIN_VALUE /10 || 临界值 ret*10 + pop +1 =Integer.MIN_VALUE -->  ret == Integer.MIN_VALUE(-2147483648)/10（去除个位） && pop < -8
     *
     * @param x 输入值
     * @return ReverseInteger
     */
    public int reverse(int x) {
        int ret = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (ret < Integer.MIN_VALUE / 10 || (ret == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            ret = ret * 10 + pop;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseIntegerV1().reverse(123));
        System.out.println(new ReverseIntegerV1().reverse(-123));
        System.out.println(new ReverseIntegerV1().reverse(120));
    }

}
