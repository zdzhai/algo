package com.yugutou.charpter5_queue_map.level2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 用一个队列实现栈
 * 从一边进，从同一边出。
 * @author dongdong
 * @Date 2023/11/25 14:35
 */
public class MyStack2 {

    private Deque<Integer> inQueue;

    public MyStack2() {
        inQueue = new LinkedList<>();
    }

    public void push(int x) {
        inQueue.addLast(x);
    }

    public int pop() {
        return inQueue.removeLast();
    }

    public int top() {
        return inQueue.getLast();
    }

    public boolean empty() {
        return inQueue.isEmpty();
    }
}
