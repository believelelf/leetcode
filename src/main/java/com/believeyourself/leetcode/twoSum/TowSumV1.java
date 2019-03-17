package com.believeyourself.leetcode.twoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wubai
 * @date 2019/3/17 22:35
 */
public class TowSumV1 {


    /**
     *  Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * Example:
     *
     * Given nums = [2, 7, 11, 15], target = 9,
     *
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     *
     * @param nums inputs
     * @param target target value
     * @return index
     */
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2){
            throw new IllegalArgumentException("the length of the parameter numbers must be greater than 2");
        }
        // value -->index
        Map<Integer, Integer> value2Index = new HashMap<>();
        for(int i =0, length = nums.length; i < length; i++){
            int differ = target - nums[i];
            if(value2Index.containsKey(differ)){
                return new int[]{value2Index.get(differ), i};
            }
            value2Index.put(nums[i], i);
        }
        throw new IllegalStateException("not found two numbers");
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TowSumV1().twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
