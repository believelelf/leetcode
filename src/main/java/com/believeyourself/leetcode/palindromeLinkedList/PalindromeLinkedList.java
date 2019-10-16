package com.believeyourself.leetcode.palindromeLinkedList;

import com.believeyourself.leetcode.domain.ListNode;

/**
 * 234. Palindrome Linked List
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2
 * Output: false
 * <p>
 * Example 2:
 * <p>
 * Input: 1->2->2->1
 * Output: true
 * <p>
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {

    /**
     * 解题思路：
     *  1. 使用快慢指针找到链表的中点
     *  2. 逆序后半部分
     *  3. 从头节点开始遍历，另一个从中间节点开始遍历，比较两个值是否一致。
     * @param head 头节点
     * @return 是回文字符串
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        // 使用快慢指针找到链表的中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // 反转链表
        slow = reverse(slow.next);
        // 遍历链表
        while (slow != null){
            if(slow.val != head.val){
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
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
}
