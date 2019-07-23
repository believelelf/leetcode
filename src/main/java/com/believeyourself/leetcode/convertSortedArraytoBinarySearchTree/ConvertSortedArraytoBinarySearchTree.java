package com.believeyourself.leetcode.convertSortedArraytoBinarySearchTree;

import com.believeyourself.leetcode.domain.TreeNode;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * Example:
 * <p>
 * Given the sorted array: [-10,-3,0,5,9],
 * <p>
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class ConvertSortedArraytoBinarySearchTree {

    /**
     * [-10,-8, -5,-4, -3,0,5,6, 7, 8, 9]
     * 0
     * /        \
     * -5         7
     * /    \      /  \
     * -8      -4
     * /       \
     * -10       -3
     * <p>
     * 解题思路：
     * 1. 针对有序数组进行二分，中间值用于构建父节点，左边子数组用于左边树，右边子数组用于构建右边树，依次进行递归。
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return sortedArrayToBSTRecursion(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBSTRecursion(int[] nums, int low, int hight) {
        if (low > hight) {
            return null;
        }
        int mid = low + ((hight - low) % 2 == 0 ? (hight - low) : (hight - low + 1)) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTRecursion(nums, low, mid - 1);
        root.right = sortedArrayToBSTRecursion(nums, mid + 1, hight);
        return root;
    }

    public static void main(String[] args) {
        /**
         *       0
         *      / \
         *    -3   9
         *    /   /
         *  -10  5
         */
        System.out.println(new ConvertSortedArraytoBinarySearchTree().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
    }


}
