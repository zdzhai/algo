package com.yugutou.charpter5_queue_hash.level2;

import java.util.Stack;

/**
 * 使用两个栈来实现队列，一个用做push,一个用做pop()和peek()
 * pop()和peek()的时候需要把inStack中的元素全部移动到outStack中
 * @author dongdong
 * @Date 2023/11/25 14:21
 */
public class MyQueue2 {

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue2() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        while (outStack.isEmpty()) {
            in2out();
        }
        return outStack.pop();
    }

    public int peek() {
        while (outStack.isEmpty()) {
            in2out();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public void in2out(){
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}
