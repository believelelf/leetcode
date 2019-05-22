package com.believeyourself.leetcode.rangeSumofBST;

/**
 * 938. Range Sum of BST
 * Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
 * <p>
 * The binary search tree is guaranteed to have unique values.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
 * Output: 32
 * Example 2:
 * <p>
 * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * Output: 23
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of nodes in the tree is at most 10000.
 * The final answer is guaranteed to be less than 2^31.
 */
public class RangeSumofBST {

    /**
     * 解题思路：
     * 1.使用深度优先搜索，使用递归搜索，判断左节点或右节点的值。
     *               10
     *            /      \
     *           5        15
     *          / \     /   \
     *         3   7   13    18
     *       /  \
     *      null 6
     * @param root
     * @param L
     * @param R
     * @return
     */
    public int rangeSumBST(TreeNode root, int L, int R) {
        return depthFirstSearch(root, L, R, 0);
    }

    private int depthFirstSearch(TreeNode node, int L, int R, int sum) {
        if (node != null) {
            if (node.val >= L && node.val <= R) {
                sum += node.val;
            }
            // search  left node
            if (node.val > L) {
                sum = depthFirstSearch(node.left, L, R, sum);
            }
            // search right node
            if (node.val < R) {
                sum = depthFirstSearch(node.right, L, R, sum);
            }
        }
        return sum;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
