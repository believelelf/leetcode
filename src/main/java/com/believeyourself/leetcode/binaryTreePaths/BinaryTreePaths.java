package com.believeyourself.leetcode.binaryTreePaths;

import com.believeyourself.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. Binary Tree Paths
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class BinaryTreePaths {

    /**
     * 构建一个StringBuilder用于拼接字符串，遍历树节点，到叶子节点将对应StringBuilder.toString()加入List<String>
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder(String.valueOf(root.val));
        dsf(root, list, builder);
        return list;
    }

    private void dsf(TreeNode root, List<String> list,  StringBuilder builder){
        if(root.left == null && root.right == null){
            list.add(builder.toString());
        }
        if(root.left != null){
            dsf(root.left, list, new StringBuilder(builder.toString()).append("->").append(root.left.val));
        }
        if(root.right != null){
            dsf(root.right, list, new StringBuilder(builder.toString()).append("->").append(root.right.val));
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        System.out.println(new BinaryTreePaths().binaryTreePaths(root));
    }
}
