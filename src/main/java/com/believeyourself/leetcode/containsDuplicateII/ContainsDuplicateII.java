package com.believeyourself.leetcode.containsDuplicateII;

import java.util.HashMap;
import java.util.Map;

/**
 * 219. Contains Duplicate II
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * Example 3:
 *
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 */
public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> integerMap = new HashMap<>(nums.length / 3);
        for(int i = 0, length = nums.length; i < length; i++){
            Integer value = integerMap.get(nums[i]);
            if(value !=null && i - value <= k){
                return true;
            }
            integerMap.put(nums[i],i);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ContainsDuplicateII().containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
        System.out.println(new ContainsDuplicateII().containsNearbyDuplicate(new int[]{1,0,1,1}, 1));
        System.out.println(new ContainsDuplicateII().containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }
}
