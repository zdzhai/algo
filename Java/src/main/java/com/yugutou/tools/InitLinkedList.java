package com.yugutou.tools;

import com.yugutou.charpter1_linklist.level1.ListNode;

/**
 * @author dongdong
 * @Date 2024/1/6 13:20
 */
public class InitLinkedList {

    public static ListNode initLinkedList(int[] array) {
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

    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.printf("%d ", head.val);
            head = head.next;
        }
        System.out.println();
    }
}
