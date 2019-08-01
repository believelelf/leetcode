package com.believeyourself.leetcode.twoSumIIInputarrayissorted;

import java.util.Arrays;

/**
 * 167. Two Sum II - Input array is sorted
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 * <p>
 * Note:
 * <p>
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Example:
 * <p>
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
public class TwoSumIIInputarrayissorted {

    /**
     * 解题思路：
     * 1. 使用两个指针，一个从数组开头向后移动，一个从数组结尾向前移动，直接两个指针对应的值和为target
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            if (target - numbers[start] == numbers[end]) {
                break;
            } else if (target - numbers[start] < numbers[end]) {
                end--;
            } else {
                start++;
            }
        }
        return new int[]{start + 1, end + 1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSumIIInputarrayissorted().twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
