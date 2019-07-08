package com.believeyourself.leetcode.mergeTwoSortedLists;

/**
 * 21. Merge Two Sorted Lists
 * Merge two sorted linked lists and return it as a new list. F
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {

    /**
     * 解题思路
     * 1. 构建一个新的链表，维护两个指针，使用拉链法对两个链表节点进行选取。
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 新的链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newListNode = new ListNode(0);
        ListNode currNode = newListNode;
        while (l1 != null && l2 != null) {
            while (l1 != null && l1.val <= l2.val) {
                currNode.next = l1;
                currNode = currNode.next;
                l1 = l1.next;
            }
            while (l2 != null && l1 != null && l2.val < l1.val) {
                currNode.next = l2;
                currNode = currNode.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            currNode.next = l1;
        }
        if (l2 != null) {
            currNode.next = l2;
        }
        return newListNode.next;
    }

    /**
     * 解题思路：leetcode solution
     * 1. 使用递归法合并两个链表
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 新的链表
     */
    public ListNode mergeTwoListsUsingRecursion(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoListsUsingRecursion(l1.next, l2);
            return  l1;
        } else {
            l2.next = mergeTwoListsUsingRecursion(l1, l2.next);
            return l2;
        }
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(5);
        l1.next.next.next.next = new ListNode(6);
        l1.next.next.next.next.next = new ListNode(8);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(7);
        l2.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next = new ListNode(10);

        System.out.println(new MergeTwoSortedLists().mergeTwoListsUsingRecursion(l1, l2));
    }


}
