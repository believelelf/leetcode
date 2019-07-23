package com.believeyourself.leetcode.maximumDepthofBinaryTree;

import com.believeyourself.leetcode.domain.TreeNode;

/**
 * 104. Maximum Depth of Binary Tree
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 */
public class MaximumDepthofBinaryTree {

    /**
     * 解题思路：
     * 1. 使用递归，构造递归函数，对于左右两边的深度取大值
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(1+ maxDepth(root.left), 1+ maxDepth(root.right));
    }

    public static void main(String[] args) {
        /**
         *  *     3
         *  *    / \
         *  *   9  20
         *  *     /  \
         *  *    15   7
         */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new MaximumDepthofBinaryTree().maxDepth(root));

    }


}
