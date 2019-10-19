package com.believeyourself.leetcode.intersectionofTwoArrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 349. Intersection of Two Arrays
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Note:
 *
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class IntersectionofTwoArrays {

    /**
     * 解法1：使用hashset保存num1的值，遍历第二个数组，查找对应值是否存在，如存在则为交集。
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> nums1Set = new HashSet<>();
        for(int i = 0; i < nums1.length; i++){
            nums1Set.add(nums1[i]);
        }
        for(int j = 0; j < nums2.length; j++){
            if(nums1Set.contains(nums2[j])){
                res.add(nums2[j]);
            }
        }
        int[]  resArray = new int[res.size()];
        int index = 0;
        for(int n : res){
            resArray[index++] = n;
        }
        return resArray;
    }

    /**
     * 解法二：对两个数组进行排序，再顺序迭代两个数组，移动对应的指针，如对应值相同添加入结果set,否则移动两个数组的指针。
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> res = new HashSet<>();
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

    /**
     * 解法三：
     *  对于其中一个数组中排序，迭代一个数组，利用二分查找求其值是否在有序数组中存在
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection3(int[] nums1, int[] nums2) {
        Set<Integer> res = new HashSet<>();
        Arrays.sort(nums2);
        for (int num : nums1) {
            if(binarySearch(num, nums2)){
                res.add(num);
            }
        }
        int[]  resArray = new int[res.size()];
        int index = 0;
        for(int n : res){
            resArray[index++] = n;
        }
        return resArray;
    }


    private boolean binarySearch(int num, int[] nums2) {
        int lo = 0;
        int hi = nums2.length - 1;
        int mid = lo + (hi - lo) / 2;
        while(lo <= hi){
            if(nums2[mid] == num){
                return true;
            }else if(nums2[mid] > num){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
            mid = lo + (hi - lo) / 2;
        }
        return false;
    }



    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};
        System.out.println(Arrays.toString(new IntersectionofTwoArrays().intersection3(nums1, nums2)));
    }

}
