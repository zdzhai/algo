package com.yugutou.charpter4_stack.level1;

/**
 * @author dongdong
 * @Date 2023/11/24 10:25
 */
public class StackByList<T> {
    class Node<T> {
        private T t;
        private Node<T> next;
    }

    public Node<T> head;

    public StackByList() {
        head = null;
    }

    //入栈
    public void push(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        if (head == null) {
            head = new Node<>();
            head.t = t;
            head.next = null;
        } else {
            Node<T> temp = head;
            head = new Node<>();
            head.t = t;
            head.next = temp;
        }
    }
}