package com.believeyourself.leetcode.implementQueueusingStacks;

import java.util.Stack;

/**
 * 232. Implement Queue using Stacks
 *
 * Implement the following operations of a queue using stacks.
 *
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Example:
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 * Notes:
 *
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 */
public class ImplementQueueusingStacks {

    public static void main(String[] args) {
          MyQueue queue = new MyQueue();
          queue.push(1);
          queue.push(2);
          System.out.println(queue.peek());  // returns 1
          System.out.println(queue.pop());   // returns 1
          System.out.println(queue.empty()); // returns false
    }
}


class MyQueue {

    private final Stack<Integer> inputStack;
    private final Stack<Integer> outputStack;
    /** Initialize your data structure here. */
    public MyQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inputStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        synchronized (inputStack){
            if(outputStack.empty()){
                for(int i =0, size = inputStack.size(); i < size; i++){
                    outputStack.push(inputStack.pop());
                }
            }
            if(!outputStack.empty()){
                return outputStack.pop();
            }
        }
        return 0;
    }

    /** Get the front element. */
    public int peek() {
        synchronized (inputStack){
            if(outputStack.empty()){
                for(int i =0, size = inputStack.size(); i < size; i++){
                    outputStack.push(inputStack.pop());
                }
            }
            if(!outputStack.empty()){
                return outputStack.peek();
            }
        }
        return 0;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inputStack.empty() && outputStack.empty();
    }
}
