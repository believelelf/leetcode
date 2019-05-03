package com.believeyourself.leetcode.implementStackusingQueues;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 225. Implement Stack using Queues
 * Implement the following operations of a stack using queues.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Example:
 * <p>
 * MyStack stack = new MyStack();
 * <p>
 * stack.push(1);
 * stack.push(2);
 * stack.top();   // returns 2
 * stack.pop();   // returns 2
 * stack.empty(); // returns false
 * Notes:
 * <p>
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */
public class ImplementStackusingQueues {


    public static void main(String[] args) {
        MyStack2 stack = new MyStack2();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());   // returns 2
        System.out.println(stack.pop());   // returns 2
        System.out.println(stack.empty()); // returns false
    }

}


/**
 * 解题思路：
 * 1.利用两个queue进行操作，一个作为输入队列，push元素，一个作为转换队列，用于将另一个队列前size-1个入队,再将最后一个元素出队。
 * 2.时间复杂度分析：push O(1) pop O(n)
 **/
class MyStack {

    private final Queue<Integer> inputQueue;
    private final Queue<Integer> transferQueue;


    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        inputQueue = new ArrayDeque<>();
        transferQueue = new ArrayDeque<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (!inputQueue.isEmpty()) {
            inputQueue.add(x);
        } else {
            transferQueue.add(x);
        }

    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (!inputQueue.isEmpty()) {
            for (int i = 0, size = inputQueue.size() - 1; i < size; i++) {
                transferQueue.add(inputQueue.poll());
            }
            return inputQueue.poll();
        }
        for (int i = 0, size = transferQueue.size() - 1; i < size; i++) {
            inputQueue.add(transferQueue.poll());
        }
        return transferQueue.poll();

    }

    /**
     * Get the top element.
     */
    public int top() {
        int top = 0;
        if (!inputQueue.isEmpty()) {
            for (int i = 0, size = inputQueue.size(); i < size; i++) {
                top = inputQueue.poll();
                transferQueue.add(top);
            }
            return top;
        }
        for (int i = 0, size = transferQueue.size(); i < size; i++) {
            top = transferQueue.poll();
            inputQueue.add(top);
        }
        return top;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return inputQueue.isEmpty() && transferQueue.isEmpty();
    }
}

/**
 * 解题思路：
 * 1.利用一个queue进行操作，在push操作时完成元素的倒换
 * 2.时间复杂度分析：push O(n) pop O(1) top O(1)
 **/
class MyStack2 {

    private final Queue<Integer> transferQueue;


    /**
     * Initialize your data structure here.
     */
    public MyStack2() {
        transferQueue = new ArrayDeque<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        transferQueue.add(x);
        for (int i = 1, size = transferQueue.size(); i < size; i++) {
            transferQueue.add(transferQueue.poll());
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return transferQueue.poll();

    }

    /**
     * Get the top element.
     */
    public int top() {
        return transferQueue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return transferQueue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */