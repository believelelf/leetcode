package com.believeyourself.leetcode.swapNodesInPairs;


import com.believeyourself.leetcode.domain.ListNode;

/**
 * @author wubai
 * @date 2019/3/26 21:40
 */
public class SwapNodesInPairs {

    /**
     * Given a linked list, swap every two adjacent nodes and return its head.
     * <p>
     * You may not modify the values in the list's nodes, only nodes itself may be changed.
     * <p>
     * Example:
     * <p>
     * Given 1->2->3->4, you should return the list as 2->1->4->3.
     * 解题思路：
     *   指针交换
     *   1. 循环遍历节点，将当前节点curr的next指向前置节点prev，并将前置节点的next指向第四个节点，如果第四个节点不存在则指向第三个节点。
     *   2. 下次循环时将第三个节点赋给prev,将第四个节点赋给curr,继续循环。
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = head;
        ListNode curr = head.next;
        prev.next = null;
        head = curr;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            if(nextNode == null || nextNode.next == null){
                // 同一组第三或第四节点为空
                prev.next = nextNode;
                break;
            }
            //指针交换
            ListNode nextNextNode = nextNode.next;
            prev.next = nextNextNode;
            prev = nextNode;
            curr = nextNextNode;
        }
        return head;
    }


    /**
     * 解题思路：
     *  新建节点
     *  1.新建一个节点，再依次遍历链表，每两个节点先添加后置节点，再添加前置节点。
     *  2.最后返回新建节点的next.
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newNode = new ListNode(-1);
        ListNode prev = head;
        ListNode curr = head.next;
        prev.next = null;
        ListNode temp = newNode;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            temp.next = curr;
            if(nextNode == null || nextNode.next == null){
                // 同一组第三或第四节点为空
                prev.next = nextNode;
                break;
            }
            ListNode nextNextNode = nextNode.next;
            temp = prev;
            prev = nextNode;
            curr = nextNextNode;
        }
        return newNode.next;
    }

    /**
     * 解题思路：
     *  递归交换前后节点
     *  将每两个节点做一次递归。
     *
     * @param head
     * @return
     */
    public ListNode swapPairs3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head.next;
        ListNode nextLoop = swapPairs3(head.next.next);
        curr.next = head;
        head.next = nextLoop;
        return curr;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        //head.next = new ListNode(2);
        //head.next.next = new ListNode(3);
        //head.next.next.next = new ListNode(4);
        //head.next.next.next.next = new ListNode(5);
        //head.next.next.next.next.next = new ListNode(6);
        ListNode output =  new SwapNodesInPairs().swapPairs3(head);
        System.out.println(output);
    }

}
