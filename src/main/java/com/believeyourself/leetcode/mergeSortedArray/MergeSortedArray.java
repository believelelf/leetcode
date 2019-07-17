package com.believeyourself.leetcode.mergeSortedArray;

import java.util.Arrays;

/**
 * 88. Merge Sorted Array
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 * <p>
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 */
public class MergeSortedArray {


    /**
     * 解题思路：
     * 1. 倒序遍历数组num1和num2,比较两个边的值大小进行占位
     * 2. 循环完成后，如果num2还有值则继续copy到num1位。
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int num1Index = m - 1;
        int num2Index = n - 1;
        int numIndex = m + n - 1;
        while (num1Index >= 0 && num2Index >= 0) {
            if (nums1[num1Index] > nums2[num2Index]) {
                nums1[numIndex--] = nums1[num1Index--];
            } else {
                nums1[numIndex--] = nums2[num2Index--];
            }
        }
        while (num2Index >= 0) {
            nums1[numIndex--] = nums2[num2Index--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        new MergeSortedArray().merge(nums1,3, new int[]{2,5,6}, 3);
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = new int[]{3,5,7,0,0,0};
        new MergeSortedArray().merge(nums2,3, new int[]{2,4,8}, 3);
        System.out.println(Arrays.toString(nums2));
    }
}
