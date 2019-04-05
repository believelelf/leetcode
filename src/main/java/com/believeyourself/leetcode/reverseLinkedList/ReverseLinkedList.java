package com.believeyourself.leetcode.reverseLinkedList;

/**
 * @author wubai
 * @date 2019/3/20 22:05
 */
public class ReverseLinkedList {

    /**
     * Reverse a singly linked list.
     *
     * Example:
     *
     * Input: 1->2->3->4->5->NULL
     * Output: 5->4->3->2->1->NULL
     * Follow up:
     *
     * A linked list can be reversed either iteratively or recursively. Could you implement both?
     *
     * 解题思路：
     *  迭代反转：
     *  1. 定义前节点prev、当前节点curr，在循环中将三次赋值操作，定义临时变量next,再将当前节点curr.next指向prev,再对prev指向curr,curr指向临时变量next。
     *  2.时间复杂度：一次循环O(n)
     *  3.空间复杂度：没有产生新的空间申请，O(1)
     *
     * @param head 头节点
     * @return 反转后接点
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 递归实现
     * --->reverse
     * @param head 头节点
     * @return 反转后接点
     */
    public ListNode reverseList2(ListNode head) {
        if(head != null && head.next != null){
            // 下一个节点
            ListNode next = head.next;
            // 最后一个节点先返回,此时next=retHead,再向下执行
            ListNode retHead =reverseList2(next);
            // 反转，将后置节点指向前置节点
            next.next = head;
            // 前置节点-->null
            head.next =null;
            return retHead;
        }
        return head;
    }

    /**
     * 节点信息
     */
    static class ListNode {
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
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        System.out.println(new ReverseLinkedList().reverseList2(head));
    }


}
