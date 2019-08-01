package com.believeyourself.leetcode.reverseKGroup;

import com.believeyourself.leetcode.domain.ListNode;

/**
 * 25. Reverse Nodes in k-Group
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * Example:
 *
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 *
 * Note:
 *
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class ReverseKGroup {


    public ListNode reverseKGroup(ListNode head, int k) {
        // 取得k+1 节点
        int count = 0;
        ListNode kPlusIndexNode = head;
        while(kPlusIndexNode != null && count != k){
            count ++;
            kPlusIndexNode = kPlusIndexNode.next;
        }

        // 判断当前节点数量是否为k,如为k,则进行递归并反转
        if(count == k){
            // 递归，处理以k分组的问题
            kPlusIndexNode = reverseKGroup(kPlusIndexNode, k);
            // 单向反转
            while(count-- > 0){
                ListNode temp = head.next;
                head.next = kPlusIndexNode;
                kPlusIndexNode = head;
                head = temp;
            }
            head = kPlusIndexNode;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        //System.out.println(new ReverseKGroup().reverseKGroup(head, 2));
        System.out.println(new ReverseKGroup().reverseKGroup(head, 3));
    }
}
