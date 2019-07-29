package com.believeyourself.leetcode.minStack;

import java.util.LinkedList;
import java.util.List;

/**
 * 155. Min Stack
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * <p>
 * <p>
 * Example:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */
public class MinStack {

    private List<Integer> list;
    private int minVal;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        list = new LinkedList<>();
        minVal = 0;
    }

    public void push(int x) {
        if (list.size() == 0 || x < minVal) {
            minVal = x;
        }
        list.add(x);
    }

    public void pop() {
        int top = list.remove(list.size() - 1);
        if (top == minVal && list.size() > 0) {
            int min = list.get(0);
            if (list.size() > 1) {
                for (int i = 1; i < list.size(); i++) {
                    min = Math.min(min, list.get(i));
                }
            }
            minVal = min;
        }
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        return minVal;
    }
}
