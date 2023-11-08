package com.yugutou.charpter1_linklist.level2.topic2_4双指针;

/**
 * Leetcode61.旋转数组
 * 先找到链表的倒数第k个节点，再把后续的节点接在链表头部
 */
public class RotateRight {

    public static void main(String[] args) {
        int[] a = {1};
        ListNode nodeA = initLinkedList(a);
        ListNode node = rotateRight(nodeA, 0);
        System.out.println(toString(node));
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode slow = head, fast = head;
        int size = 0;
        while (fast != null && k > 0) {
            fast = fast.next;
            size++;
            k--;
        }
        if (k > 0) {
            k = k % size;
            fast = head;
            while (fast != null && k > 0) {
                fast = fast.next;
                size++;
                k--;
            }
        }
        ListNode temp = slow;
        while (fast != null) {
            fast = fast.next;
            temp = slow;
            slow = slow.next;
        }
        ListNode head1 = temp.next;
        temp.next = null;
        temp = head1;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        return head1;
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

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
