package com.yugutou.charpter1_linklist;

import com.yugutou.charpter1_linklist.level1.ListNode;

/**
 * leetcode 61.旋转链表
 * @author dongdong
 * @Date 2023/12/29 13:30
 */
public class RotateRight {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        ListNode nodeA = initLinkedList(a);
        System.out.println(rotateRight(nodeA,4).val);
    }

    /**
     * 先把k归在链表长度范围内，链表长度需要遍历一次才知道
     * 直接找到链表倒数第k个节点，然后将其移动到链表头部
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode node = head;
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }
        k %= size;
        if (k == 0) {
            return head;
        }
        ListNode slow = head, fast = head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode nodeA = slow.next;
        node = nodeA;
        while (node.next != null) {
            node = node.next;
        }
        node.next = head;
        slow.next = null;
        return nodeA;
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
}
