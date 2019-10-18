package com.believeyourself.leetcode.moveZeroes;

import java.util.Arrays;

/**
 * 283. Move Zeroes
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeroes {
    /**
     *解题思路：
     *  遍历数组，将非0值向前移动，再将后续下标填充0
     */
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }

        int nonZeroIndex = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[nonZeroIndex++] = nums[i];
            }
        }
        for(int i = nonZeroIndex; i < nums.length; i++){
            nums[nonZeroIndex++] = 0;
        }
    }

    public static void main(String[] args) {
        int [] arr = new int[]{0,1,0,3,12};
        new MoveZeroes().moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}
