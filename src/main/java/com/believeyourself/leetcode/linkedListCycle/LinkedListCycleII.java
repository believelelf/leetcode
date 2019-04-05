package com.believeyourself.leetcode.linkedListCycle;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wubai
 * @date 2019/3/28 23:35
 */
public class LinkedListCycleII {

    /**
     * 142. Linked List Cycle II
     *
     * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
     *
     * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
     *
     * Note: Do not modify the linked list.
     *
     *
     * Example 1:
     *
     * Input: head = [3,2,0,-4], pos = 1
     * Output: tail connects to node index 1
     * Explanation: There is a cycle in the linked list, where tail connects to the second node.
     *
     * 解题思路：
     *  使用一个set保存经过的节点，如果环存在则有环的起点。
     * @param head
     *
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        Set<ListNode> visitedNodes = new HashSet<>();
        ListNode curr = head;
        while (curr != null){
            if(visitedNodes.contains(curr)){
                return curr;
            }
            visitedNodes.add(curr);
            curr = curr.next;
        }
        return null;
    }


    public ListNode detectCycle2(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode meetNode = null;
        while (true){
            slow = slow.next;
            if(fast == null || fast.next == null){
                return null;
            }
            fast = fast.next.next;
            if(slow == fast){
                meetNode = slow;
                break;
            }
        }
        // 第二次循环，第一个节点从head开始，第二个节点从meetNode开始，应该在环起点相遇。
        while(head != meetNode){
            head = head.next;
            meetNode = meetNode.next;
        }
        return head;

    }

    class ListNode {

        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

}
