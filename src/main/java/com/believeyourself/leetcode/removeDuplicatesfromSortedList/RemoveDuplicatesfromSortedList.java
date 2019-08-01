package com.believeyourself.leetcode.removeDuplicatesfromSortedList;

import com.believeyourself.leetcode.domain.ListNode;

/**
 * 83. Remove Duplicates from Sorted List
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 * <p>
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class RemoveDuplicatesfromSortedList {

    /**
     * 解题思路：
     * 1. 循环迭代链表
     * @param head 链表头
     * @return head
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode curr = head;
        ListNode next = head.next;
        while(next != null){
            if(curr.val == next.val){
                curr.next = next.next;
            }else{
                curr = next;
            }
            next = next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        // 1->1->2->3->3
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        System.out.println(new RemoveDuplicatesfromSortedList().deleteDuplicates(head));
    }
}
