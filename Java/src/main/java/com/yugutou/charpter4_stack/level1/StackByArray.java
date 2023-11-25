package com.yugutou.charpter4_stack.level1;

import java.util.Arrays;

/**
 * @author dongdong
 * @Date 2023/11/24 10:08
 */
public class StackByArray<T> {
    private int top = 0;

    private Object[] stack;

    public StackByArray() {
        stack = new Object[10];
    }

    public void push(T t) {
        expandCapacity(stack.length + 1);
        stack[top] = t;
        top++;
    }

    public T pop() {
        T t = peek();
        if (top > 0) {
            stack[top - 1] = null;
            top--;
        }
        return t;
    }

    public T peek() {
        T t = null;
        if (top > 0) {
            t = (T) stack[top - 1];
        }
        return t;
    }
    public boolean isEmpty() {
        return top == 0;
    }

    //扩大容量
    public void expandCapacity(int size) {
        int len = stack.length;
        if (size > len) {
            size = size * 3 / 2 + 1;//每次扩大50%
            stack = Arrays.copyOf(stack, size);
        }
    }
}
