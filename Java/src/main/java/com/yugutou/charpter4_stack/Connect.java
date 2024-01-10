package com.yugutou.charpter4_stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode. 116. 填充每个节点的下一个右侧节点指针
 * @author dongdong
 * @Date 2024/1/9 19:57
 */
public class Connect {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(connect(root));
    }

    /**
     * 使用层序遍历的思路
     * @param root
     * @return
     */
    public static Node connect(Node root) {
        if (root == null) return null;
        Deque<Node> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size > 0) {
                Node poll = deque.remove();
                if (poll.left != null) deque.offer(poll.left);
                if (poll.right != null) deque.offer(poll.right);
                if (size == 1) {
                    poll.next = null;
                } else {
                    poll.next = deque.peek();
                }
                size--;
            }
        }
        return root;
    }

}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}