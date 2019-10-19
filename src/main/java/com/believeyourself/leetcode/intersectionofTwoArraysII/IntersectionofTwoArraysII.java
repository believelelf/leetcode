package com.believeyourself.leetcode.intersectionofTwoArraysII;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 350. Intersection of Two Arrays II
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Note:
 *
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 *
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class IntersectionofTwoArraysII {

    /**
     * 对两个数组进行排序，移动对应的指针，如两个的值相等，使用list进行接收。
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new LinkedList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        while (i < nums1Length && j < nums2Length){
            if(nums1[i] < nums2[j]){
                i++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else{
                res.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[]  resArray = new int[res.size()];
        int index = 0;
        for(int n : res){
            resArray[index++] = n;
        }
        return resArray;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};
        System.out.println(Arrays.toString(new IntersectionofTwoArraysII().intersect(nums1, nums2)));
    }
}
