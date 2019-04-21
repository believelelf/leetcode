package com.believeyourself.leetcode.firstMissingPositive;

/**
 * 41. First Missing Positive
 * Given an unsorted integer array, find the smallest missing positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 * <p>
 * Input: [7,8,9,11,12]
 * Output: 1
 * Note:
 * <p>
 * Your algorithm should run in O(n) time and uses constant extra space.
 */
public class FirstMissingPositive {

    /**
     * 解题思路:利用位图标记数字是否出现过，但非常量空间。
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        char[] bytes = new char[Integer.MAX_VALUE / 16 + 1];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num < 0) {
                continue;
            }
            int index = num / 16;
            int pos = num % 16;
            bytes[index] |= (1 << pos);
        }
        for (int i = 0; i < bytes.length; i++) {
            for (int j = (i == 0 ? 1 : 0); j < 16; j++) {
                if ((bytes[i] & 1 << j) == 0) {
                    return i * 16 + j;
                }
            }
        }
        return 1;
    }

    /**
     * 解题思路：
     * 1.对于数组中出现的每个元素进行遍历，判断是否存在小于1或大于数组的长度，如果不符合则i++，因为此类值不符合最小正整数要求。
     * 2.对于数组元素判断nums[i]==i+1即类nums[0]==1序列是否存在，如果存在即此下标i可对应的最小正数,继续循环。
     * 3.对于其他不符合nums[nums[i]-1] == nums[i]模型的数据，则对两数的位置进行交换。
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive2(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i + 1 || nums[i] < 1 || nums[i] > nums.length || nums[nums[i] - 1] == nums[i]) {
                i++;
            } else {
                swap(nums, i, nums[i] - 1);
            }
        }
        i = 0;
        while (i < nums.length && nums[i] == i + 1) {
            i++;
        }
        return i + 1;
    }

    private void swap(int[] nums, int originIndex, int swapIndex) {
        int temp = nums[originIndex];
        nums[originIndex] = nums[swapIndex];
        nums[swapIndex] = temp;
    }


    public static void main(String[] args) {
        int[] inputs = new int[]{1, 2, 0};
        System.out.println(new FirstMissingPositive().firstMissingPositive2(inputs));
        inputs = new int[]{3, 4, -1, 1};
        System.out.println(new FirstMissingPositive().firstMissingPositive2(inputs));
        inputs = new int[]{7, 8, 9, 11, 12};
        System.out.println(new FirstMissingPositive().firstMissingPositive2(inputs));
    }

}
