package com.believeyourself.leetcode.removeElement;

import java.util.Arrays;

/**
 * 27. Remove Element
 * <p>
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * <p>
 * Example 1:
 * <p>
 * Given nums = [3,2,2,3], val = 3,
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 2.
 * <p>
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 * <p>
 * Given nums = [0,1,2,2,3,0,4,2], val = 2,
 * <p>
 * Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
 * <p>
 * Note that the order of those five elements can be arbitrary.
 * <p>
 * It doesn't matter what values are set beyond the returned length.
 * Clarification:
 * <p>
 * Confused why the returned value is an integer but your answer is an array?
 * <p>
 * Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
 * <p>
 * Internally you can think of this:
 * <p>
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeElement(nums, val);
 * <p>
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 */
public class RemoveElement {

    /**
     * 解题思路
     * 1. 维护两个指针，一个从前往后移动，一个从后往前移动，将后移得到不为指定值元素填入前移指定值的slot。
     * 2. 对于长度值维护一个单独的计数变量
     *
     * @param nums input nums
     * @param val  the value
     * @return 移除指定值后的数组长度
     */
    public int removeElement(int[] nums, int val) {
        int lastIndex = nums.length - 1;
        int retLen = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                // 计数减1
                retLen--;
                while (lastIndex > i && nums[lastIndex] == val) {
                    lastIndex--;
                    retLen--;
                }
                nums[i] = nums[lastIndex];
                lastIndex--;
            }
            if (i >= lastIndex) {
                break;
            }
        }
        return retLen;
    }

    public static void main(String[] args) {
        int[] ret = new int[]{3, 2, 2, 3};
        System.out.println(new RemoveElement().removeElement(ret, 3));
        System.out.println(Arrays.toString(ret));
        ret = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(new RemoveElement().removeElement(ret, 2));
        System.out.println(Arrays.toString(ret));
        ret = new int[]{4,5};
        System.out.println(new RemoveElement().removeElement(ret, 5));
        System.out.println(Arrays.toString(ret));

    }

}
