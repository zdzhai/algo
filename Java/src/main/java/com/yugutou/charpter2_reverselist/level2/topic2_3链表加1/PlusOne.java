package com.yugutou.charpter2_reverselist.level2.topic2_3链表加1;

import java.util.Stack;

/**
 * LeetCode369 单链表加1
 */
public class PlusOne {
    public static void main(String[] args) {
        //int[] a = {7, 8};
        int[] a = {9,9,9};
        //int[] a = {1, 2, 3};
        ListNode nodeA = initLinkedList(a);

        ListNode node = plusOne(nodeA);

        System.out.println(toString(node));

    }

    /**
     * 需要注意进位以及如果进位后位数不够了需要往前边补一位
     * @param head
     * @return
     */
    public static ListNode plusOne(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        int front = 0;
        int add = 1;
        ListNode dummyNode = new ListNode(0);
        while (!stack.isEmpty() || front == 1) {
            ListNode last = stack.isEmpty() ? new ListNode(0) : stack.pop();
            int val = last.val + add + front;
            front = val >= 10 ? 1 : 0;
            last.val = val >= 10 ? val - 10 : val;
            cur = new ListNode(last.val);
            cur.next = dummyNode.next;
            dummyNode.next = cur;
            add = 0;
        }
        return dummyNode.next;
    }


    /**
     * 初始化链表
     *
     * @param array
     * @return
     */
    private static ListNode initLinkedList(int[] array) {
        ListNode head = null, cur = null;

        for (int i = 0; i < array.length; i++) {
            ListNode newNode = new ListNode(array[i]);
            newNode.next = null;
            if (i == 0) {
                head = newNode;
                cur = head;
            } else {
                cur.next = newNode;
                cur = newNode;
            }
        }
        return head;
    }


    /**
     * 输出链表
     *
     * @param head 头节点
     */
    public static String toString(ListNode head) {
        ListNode current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.val).append("\t");
            current = current.next;
        }
        return sb.toString();
    }

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
