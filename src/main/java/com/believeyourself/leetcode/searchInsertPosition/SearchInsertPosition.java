package com.believeyourself.leetcode.searchInsertPosition;

/**
 * 35. Search Insert Position
 * <p>
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * You may assume no duplicates in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 * <p>
 * Input: [1,3,5,6], 2
 * Output: 1
 *
 * Example 3:
 * <p>
 * Input: [1,3,5,6], 7
 * Output: 4
 *
 * Example 4:
 * <p>
 * Input: [1,3,5,6], 0
 * Output: 0
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }


    public static void main(String[] args) {
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1,3,5,6}, 7));
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1,3,5,6}, 0));
    }
}
