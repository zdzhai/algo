package com.yugutou.charpter4_stack.level2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author dongdong
 * @Date 2023/11/24 11:02
 */
public class MinStack2 {
    Deque<Integer> minStack;
    Deque<Integer> stack;

    public MinStack2() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int val) {
        int min = minStack.isEmpty() ? val : minStack.peek();
        minStack.push(Math.min(min, val));
        stack.push(val);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
