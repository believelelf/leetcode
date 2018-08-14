// Source : https://oj.leetcode.com/problems/two-sum/
// Author : Baiyi Wu
// Date   : 2018-08-14

/*
 *  Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *  You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *  Example:
 *  Given nums = [2, 7, 11, 15], target = 9,
 *  Because nums[0] + nums[1] = 2 + 7 = 9,
 *  return [0, 1].
 */
package com.believeyourself.leetcode.twoSum;

import java.util.HashMap;
import java.util.Map;

public class TowSum {

    /**
     * Approach 1: Brute Force
     * The brute force approach is simple. Loop through each element xx and find if there is another value that equals to target - xtarget−x.
     * <p>
     * Complexity Analysis
     * Time complexity : O(n^2)O(n2). For each element, we try to find its complement by looping through the rest of array which takes O(n)O(n) time. Therefore, the time complexity is O(n^2)O(n​2).
     * Space complexity : O(1)O(1).
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target - nums[i] == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * Approach 2: Two-pass Hash Table
     * To improve our run time complexity, we need a more efficient way to check if the complement exists in the array. If the complement exists, we need to look up its index. What is the best way to maintain a mapping of each element in the array to its index? A hash table.
     * <p>
     * We reduce the look up time from O(n)O(n) to O(1)O(1) by trading space for speed. A hash table is built exactly for this purpose, it supports fast look up in near constant time. I say "near" because if a collision occurred, a look up could degenerate to O(n)O(n) time. But look up in hash table should be amortized O(1)O(1) time as long as the hash function was chosen carefully.
     * <p>
     * A simple implementation uses two iterations. In the first iteration, we add each element's value and its index to the table. Then, in the second iteration we check if each element's complement (target - nums[i]target−nums[i]) exists in the table. Beware that the complement must not be nums[i]nums[i] itself!
     */
    public int[] towSumByTowPassHashTable(int[] nums, int target) {
        // for each array into a map
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        // check if each element'complement exists in the table
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No tow sum solution");
    }

    /**
     * Approach 3: One-pass Hash Table
     * It turns out we can do it in one-pass. While we iterate and inserting elements into the table, we also look back to check if current element's complement already exists in the table. If it exists, we have found a solution and return immediately.
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] towSumByOnePassHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int complement = target - num;
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(num, i);
        }
        throw new IllegalArgumentException("No tow sum solution");
    }


}
