package com.believeyourself.leetcode.binaryTreeLevelOrderTraversalII;

import com.believeyourself.leetcode.domain.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107. Binary Tree Level Order Traversal II
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its bottom-up level order traversal as:
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class BinaryTreeLevelOrderTraversalII {


    /**
     * 解题思路1
     * 1.利用广度优先搜索算法及队列数据结构，以同级节点个数为循环进行遍历
     *
     * @param root 根节点
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        if (root == null) {
            return lists;
        }
        // 构建一个同级节点组成的Queue,左节点先入队
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 以同级节点个数为循环条件，在一个循环中出队上一级节点，入队下一级节点。
        while (!queue.isEmpty()) {
            // 上一级节点个数
            int size = queue.size();
            List<Integer> values = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                // 取出上一级节点（size个）
                TreeNode parentNode = queue.poll();
                // 入队下一级节点
                if (parentNode.left != null) {
                    queue.offer(parentNode.left);
                }
                if (parentNode.right != null) {
                    queue.offer(parentNode.right);
                }
                values.add(parentNode.val);
            }
            // 前追加
            lists.add(0, values);
        }
        return lists;
    }


    /**
     * 解题思路2
     * 1.利用深度优先搜索算法，使用递归算法，递归函数中传入List及递归层次
     *
     * @param root 根节点
     * @return
     */
    public List<List<Integer>> levelOrderBottomDFS(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        dfs(lists, root, 0);
        return lists;
    }

    private void dfs(List<List<Integer>> lists, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        // 如果当前层级对应List<Integer>未添加，则先添加
        if (level >= lists.size()) {
            lists.add(0,new LinkedList<>());
        }
        // 递归调用
        dfs(lists, root.left, level + 1);
        dfs(lists, root.right, level + 1);
        // 根据节点层级取出List<Integer>进行val添加，注意顺序
        lists.get(lists.size() - level - 1).add(root.val);
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
        System.out.println(new BinaryTreeLevelOrderTraversalII().levelOrderBottomDFS(root));
    }


}
