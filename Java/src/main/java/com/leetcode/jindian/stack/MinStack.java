package com.leetcode.jindian.stack;

import java.util.Stack;

/**
 * @author dongdong
 * @Date 2024/9/1 10:52
 * 面试题03.02.栈的最小值
 */
public class MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();   //--> 返回 -3.
        minStack.pop();
        minStack.top();      //--> 返回 0.
        minStack.getMin();   //--> 返回 -2.
    }

    /**
     * 需要用到两个栈，一个记录实际值，一个记录最小值栈
     * stack    -2 0 -3
     * minStack -2 -2 -3
     */
    Stack<Integer> stack = null;
    Stack<Integer> minStack = null;

    public MinStack() {
        this.stack = new Stack<Integer>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (!minStack.isEmpty() && minStack.peek() < x) {
            minStack.push(minStack.peek());
        } else {
            minStack.push(x);
        }
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
