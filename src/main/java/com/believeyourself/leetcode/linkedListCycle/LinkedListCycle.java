package com.believeyourself.leetcode.linkedListCycle;

import com.believeyourself.leetcode.domain.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wubai
 * @date 2019/3/26 20:55
 */
public class LinkedListCycle {

    /**
     * Given a linked list, determine if it has a cycle in it.
     *
     * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
     *
     *Example 1:
     *
     * Input: head = [3,2,0,-4], pos = 1
     * Output: true
     * Explanation: There is a cycle in the linked list, where tail connects to the second node.
     *
     * 解题思路：
     *    1.定义一个Set,用于存放访问过的节点。
     *    2.遍历链表，如果节点已经在set出现过则存在环。
     *    时间复杂度：查找O(n) 添加节点O(1)
     *    空间复杂度：O(n)
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visitedNodes = new HashSet<>();
        ListNode curr = head;
        while (curr != null){
            if(visitedNodes.contains(curr)){
                return true;
            }
            visitedNodes.add(curr);
            curr = curr.next;
        }
        return false;
    }

    /**
     * 解题思路：
     *    见leetCode解法
     *    1. 利用快慢节点（两步与一步）相遇来检测是否有环。
     *    2. 如无环，快慢节点不会相遇，一次遍历，时间复杂度O(n)
     *    3. 如存在环，经过循环外节点+循环外两者距离差会相遇，时间复杂度为O(n)
     *
     *    时间复杂度：O(n)
     *    空间复杂度：O(1)
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (true){
            if(slow == fast){
                return true;
            }
            slow = slow.next;
            if(fast == null || fast.next == null){
                return false;
            }
            fast = fast.next.next;
        }
    }

}
