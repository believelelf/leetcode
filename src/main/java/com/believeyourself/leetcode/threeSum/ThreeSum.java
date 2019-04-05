package com.believeyourself.leetcode.threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wubai
 * @date 2019/4/4 23:11
 * <p>
 * 15. 3Sum
 * <p>
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSum {

    /**
     * 解题思路：
     * 1.先判断数组是否为空及元素个数是否小于3个，如是返回空集合
     * 2.如为三个,判断a+b+c=0是否相符
     * 3.大于3个作为一类进行处理，先对数据进行排序，使其成为一个有序数组。
     * 4.从下标0开始取和数sum下标sumIndex，从数组下一下标取低位min、从最高位取值max,在[sumIndex+1,nums.length-1] 的范围内求sum=-(min+max),如存在添加此组合结果集中。
     * 5.判断时在外层遍历sumIndex ~ [0, nums.length-2),在循环内移动minIndex与maxIndex.
     * 6.minIndex与maxIndex的移动规则：
     * 1)如果取得sum=-(min+max)，则将minIndex++并maxIndex--,两边都进行变动，因为不会再存在2个值不同，第3个值还变动的组合。
     * 2)如果取得sum>-max-min,则本次将移动下标maxIndex--,否则移动下标minIndex++
     * 3)一轮移动的结束条件为minIndex<maxIndex
     * 7.为消除重复组合，做以下判断：
     * 1)外层循环需要从下标1开始判断sumIndex与sumIndex-1位的值是否相等，如相等过滤(即会存在三个相同的数)，从下标1开始是因为要保证循环至少执行一次，如[0,0,0,0,0,0]组合
     * 2)对于6.1)中sum-(min+max),需要对min、max与其各自下一元素进行判断，直到不相等。
     *
     * @param nums 输入数组
     * @return 三个不同元素的a+b+c=0的组合
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>(0);
        }
        List<List<Integer>> ret = new ArrayList<>(3);
        if (nums.length == 3) {
            if (nums[0] + nums[1] + nums[2] == 0) {
                ret.add(Arrays.asList(nums[0], nums[1], nums[2]));
                return ret;
            }
            return ret;
        }
        Arrays.sort(nums);
        for (int sumIndex = 0; sumIndex < nums.length - 2; sumIndex++) {
            int minIndex = sumIndex+1;
            int maxIndex = nums.length - 1;
            // 过滤重复组合，并保证至少执行一次
            if (sumIndex == 0 || nums[sumIndex] != nums[sumIndex - 1]) {
                // 开始内循环
                while (minIndex < maxIndex) {
                    int sum = nums[sumIndex];
                    int min = nums[minIndex];
                    int max = nums[maxIndex];
                    if (sum == -(max + min)) {
                        ret.add(Arrays.asList(sum, min, max));
                        // 消除内循环重复元素
                        while (max == nums[maxIndex - 1] && maxIndex > minIndex) {
                            maxIndex--;
                        }
                        while (min == nums[minIndex + 1] && minIndex < maxIndex) {
                            minIndex++;
                        }
                        // 将两数移动下一个不相同的数，
                        maxIndex--;
                        minIndex++;
                    } else if (sum > -(max + min)) {
                        maxIndex--;
                    } else {
                        minIndex++;
                    }
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum(new int[]{-1, 0, 1, 0}));
        System.out.println(new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(new ThreeSum().threeSum(new int[]{-2, 0, 1, 1, 2}));
        System.out.println(new ThreeSum().threeSum(new int[]{0, 0, 0, 0, 0, 0}));
    }
}
