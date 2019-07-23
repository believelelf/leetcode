package com.believeyourself.leetcode.balancedBinaryTree;

import com.believeyourself.leetcode.domain.TreeNode;

/**
 * 110. Balanced Binary Tree
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * For this problem, a height-balanced binary tree is defined as:
 * <p>
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * Example 1:
 * <p>
 * Given the following tree [3,9,20,null,null,15,7]:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * Return true.
 * <p>
 * Example 2:
 * <p>
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * Return false.
 */
public class BalancedBinaryTree {

    /**
     * 解题思路：
     * 1. 使用深度优化搜索算法，使用递归求取一个节点左右两边路径的最大深度，如果两边深度相差大于1，则返回false,进行一次迭代，如果满足条件退出迭代。
     * 2. 由于存在提前退出条件，相关每一层都会判断高度差。时间复杂度为O(N)
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    /**
     * 结束条件为-1，代表则非平衡。
     *
     * @param root
     * @return
     */
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 递归求取基于当前节点的左边节点的最大深度
        int leftDepth = dfs(root.left);
        if (leftDepth == -1) {
            return -1;
        }
        // 递归求取基于当前节点的右边节点的最大深度
        int rightDepth = dfs(root.right);
        if (rightDepth == -1) {
            return -1;
        }
        // 如果两边节点的最大深度差大于1，则不平衡
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        /**
         *       1
         *       / \
         *      2   2
         *     / \
         *    3   3
         *   / \
         *  4   4
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);
        System.out.println(new BalancedBinaryTree().isBalanced(root));

    }

}
