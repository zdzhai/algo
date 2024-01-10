package com.yugutou.charpter1_linklist;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 138. 随机链表的复制
 *
 * @author dongdong
 * @Date 2024/1/9 20:27
 */
public class CopyRandomList {
    public static void main(String[] args) {

    }

    /**
     * 按顺序遍历链表，新建node，指向，random可以使用hash快速获取
     *
     * @param head
     * @return
     */
    public static Node copyRandomList(Node head) {
        if (head == null) return null;
        Node newHead = new Node(head.val);
        Map<Node, Node> map = new HashMap<>();
        Node origin = head;
        map.put(head, newHead);
        origin = origin.next;
        //构建新老映射
        while (origin != null) {
            map.put(origin, new Node(origin.val));
            origin = origin.next;
        }

        Node tail = newHead;
        origin = head;
        while (origin != null) {
            tail.random = map.get(origin.random);
            tail.next = map.get(origin.next);
            tail = tail.next;
            origin = origin.next;
        }
        return newHead;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}