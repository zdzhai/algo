package com.yugutou.charpter1_linklist.level1;

/**
 * 一个简单的链表实例，用于演示JVM怎么构造链表的
 */
public class BasicLink {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        Node head = initLinkedList(a);
        System.out.println(head);
    }

    private static Node initLinkedList(int[] array) {
        Node head = null, cur = null;
        for (int i = 0; i < array.length; i++) {
            Node newNode = new Node(array[i]);
            newNode.next = null;
            if (i == 0) {
                head = newNode;
                cur = newNode;
            } else {
                cur.next = newNode;
                cur = newNode;
            }
        }
        return head;
    }

    static class Node {
        public int val;
        public Node next;

        Node(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 链表尾部添加节点
     * @param head 原始链表头节点
     * @param newNode 新增节点
     */
    public static void addNodeInEnd(Node head, Node newNode) {
        Node node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = newNode;
    }

    /**
     * 链表头部添加节点
     * @param head 原始链表头节点
     * @param newNode 新增节点
     */
    public static Node addNodeInHead(Node head, Node newNode) {
        newNode.next = head;
        head = newNode;
        return head;
    }

    /**
     * 链表中间添加节点
     * @param head
     * @param val
     * @param newNode
     * @return
     */
    public static Node addNodeInMid(Node head, int val, Node newNode) {
        Node node = head;
        while (node.val != val) {
            node = node.next;
        }
        /*Node temp = node.next;
        node.next = newNode;
        newNode.next = temp;*/
        newNode.next = node.next;
        node.next = newNode;
        return head;
    }

    /**
     * 链表删除节点
     * @param head 原始链表头节点
     * @param removeVal 要删除的节点
     */
    public static void removeNode(Node head, int removeVal) {
        if (head == null) {
            return;
        }
        Node node = head;
        while (node.next.val != removeVal) {
            node = node.next;
        }
        node.next = node.next.next;
    }

    class DoubleNode {
        private int val;
        private DoubleNode left;
        private DoubleNode right;

        public DoubleNode(int val) {
            this.val = val;
        }

        public DoubleNode(int val, DoubleNode left, DoubleNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
