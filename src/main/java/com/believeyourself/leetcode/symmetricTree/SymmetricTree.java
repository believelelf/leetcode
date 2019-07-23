package com.believeyourself.leetcode.symmetricTree;


import com.believeyourself.leetcode.domain.TreeNode;

import java.util.Stack;

/**
 * 101. Symmetric Tree
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p>
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * <p>
 * <p>
 * But the following [1,2,2,null,3,null,3] is not:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * <p>
 * <p>
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */
public class SymmetricTree {

    /**
     * 解题思路：
     * 1. 使用递归，构造递归函数，使left.left.val == right.right.val && left.right.val == right.left.val
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricEquals(root.left, root.right);
    }

    /**
     * 递归函数
     * @param left 左节点
     * @param right 右节点
     * @return 是符合对称相等
     */
    private boolean isSymmetricEquals(TreeNode left, TreeNode right) {
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetricEquals(left.left, right.right) && isSymmetricEquals(left.right, right.left);
    }




    /**
     * 解题思路2：
     *  1. 使用迭代法和数据结构栈，对于left.left和right.right不为null时进行压栈，对于left.right和right.left不为null进行压栈
     *  2. 每次循环判断一次出栈，两种入栈情况,以栈为空结束条件
     *  3. 在循环栈初始压入左右节点
     * @param root 根节点
     * @return 是否对称相等
     */
    public boolean isSymmetricUsingIteration(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 定义左右节点
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 定义一个Stack，用于保存子节点
        Stack<TreeNode> stack = new Stack<>();
        if(left != null){
            if(right == null){
                return false;
            }
            stack.push(left);
            stack.push(right);
        }else if(right != null){
            return false;
        }
        // 对于子节点进行迭代，以stack是否为空为循环条件，一个循环伴随着两次出栈及可能的四次入栈操作
        while (!stack.isEmpty()){
            left = stack.pop();
            right = stack.pop();
            // 对于左右节点的值进行判断
            if(left.val != right.val){
                return false;
            }

            // 进行入栈操作判断,先判断left.left && right.right
            if(left.left != null){
                if(right.right == null){
                    return false;
                }
                stack.push(left.left);
                stack.push(right.right);
            }else if(right.right != null) {
                return false;
            }

            // 判断left.right && right.left
            if(left.right != null){
                if(right.left  == null){
                    return false;
                }
                stack.push(left.right);
                stack.push(right.left);
            }else if(right.left != null){
                return false;
            }
        }

        // left && right is null
        return true;
    }


    public static void main(String[] args) {
        /**
         *  * 1
         *  * / \
         *  * 2   2
         *  * / \ / \
         *  * 3  4 4  3
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(new SymmetricTree().isSymmetricUsingIteration(root));

    }


}
