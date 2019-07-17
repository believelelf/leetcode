package com.believeyourself.leetcode.sameTree;

import java.util.Objects;

/**
 * 100. Same Tree
 * Given two binary trees, write a function to check if they are the same or not.
 * <p>
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 * <p>
 * Example 1:
 * <p>
 * Input:     1         1
 * / \       / \
 * 2   3     2   3
 * <p>
 * [1,2,3],   [1,2,3]
 * <p>
 * Output: true
 * Example 2:
 * <p>
 * Input:     1         1
 * /           \
 * 2             2
 * <p>
 * [1,2],     [1,null,2]
 * <p>
 * Output: false
 * Example 3:
 * <p>
 * Input:     1         1
 * / \       / \
 * 2   1     1   2
 * <p>
 * [1,2,1],   [1,1,2]
 * <p>
 * Output: false
 */
public class SameTree {


    /**
     * 解题思路：
     * 1）方法一：重写对象的equals方法
     * 2）方法二：利用深度优先搜索方法，比较两个树的节点值，如果存在值不一致则为false
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        if(!isSameTree(p.left, q.left)){
            return false;
        }
        if(!isSameTree(p.right, q.right)){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.right = new TreeNode(2);
        head.left = new TreeNode(3);

        TreeNode head2 = new TreeNode(1);
        head2.right = new TreeNode(2);
        head2.left = new TreeNode(3);

        System.out.println(new SameTree().isSameTree(head, head2));


        TreeNode head3 = new TreeNode(1);
        head3.right = new TreeNode(2);
        head3.left = new TreeNode(1);

        TreeNode head4 = new TreeNode(1);
        head4.right = new TreeNode(1);
        head4.left = new TreeNode(2);

        System.out.println(new SameTree().isSameTree(head3, head4));


    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode treeNode = (TreeNode) o;
            return val == treeNode.val &&
                    Objects.equals(left, treeNode.left) &&
                    Objects.equals(right, treeNode.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right);
        }
    }


}
