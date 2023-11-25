package com.yugutou.charpter4_stack.level2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author dongdong
 * @Date 2023/11/24 15:20
 */
public class MaxStack2 {

    private Deque<Integer> stack;
    private Deque<Integer> maxStack;

    public MaxStack2() {
        stack = new LinkedList<>();
        maxStack = new LinkedList<>();
    }

    public void push(int val) {
        stack.push(val);
        maxStack.push(Math.max(maxStack.peek(), val));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMax() {
        return maxStack.peek();
    }
}
