package com.believeyourself.leetcode.lowestCommonAncestorofaBinarySearchTree;

import com.believeyourself.leetcode.domain.TreeNode;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * Example 2:
 * <p>
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 * <p>
 * <p>
 * Note:
 * <p>
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the BST.
 */
public class LowestCommonAncestorofaBinarySearchTree {

    /**
     * 递归遍历二叉树，保留p节点的父节点，保留q的父节点，再做比较。
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if(root.val == p.val){
          return p;
      }
      if(root.val == q.val){
          return q;
      }
      if(p.val < root.val && q.val < root.val){
          return lowestCommonAncestor(root.left, p, q);
      }
      if(p.val > root.val && q.val > root.val){
          return lowestCommonAncestor(root.right, p, q);
      }
      return root;
    }

    public static void main(String[] args) {
        // root = [6,2,8,0,4,7,9,null,null,3,5]
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        System.out.println(new LowestCommonAncestorofaBinarySearchTree().lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4)));
    }

}
