package com.believeyourself.leetcode.removeLinkedListElements;

import com.believeyourself.leetcode.domain.ListNode;

/**
 * 203. Remove Linked List Elements
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */
public class RemoveLinkedListElements {

    /**
     * 解题思路：
     * 1. 迭代链表,构建一个哨兵节点
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode temp = dump;
        while (temp.next != null){
            if (temp.next.val == val){
                temp.next = temp.next.next;
            }else {
                temp = temp.next;
            }
        }
        return dump.next;
    }

    public static void main(String[] args) {
        //1->2->6->3->4->5->6, val = 6
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);
        System.out.println(new RemoveLinkedListElements().removeElements(head,6));
    }
}
