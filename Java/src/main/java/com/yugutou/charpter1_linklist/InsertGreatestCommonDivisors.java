package com.yugutou.charpter1_linklist;

import com.yugutou.charpter1_linklist.level1.ListNode;
import com.yugutou.tools.InitLinkedList;

/**
 * leetcode 2807. 在链表中插入最大公约数
 * @author dongdong
 * @Date 2024/1/6 13:07
 */
public class InsertGreatestCommonDivisors {
    public static void main(String[] args) {
        int[] a = {7};

        ListNode head = InitLinkedList.initLinkedList(a);
        InitLinkedList.printLinkedList(insertGreatestCommonDivisors(head));
    }

    public static ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode cur = head, next = head.next;
        while (next != null) {
            int max = Math.max(cur.val, next.val);
            int min = Math.min(cur.val, next.val);
            ListNode insert = new ListNode(gcd(max, min));
            cur.next = insert;
            insert.next = next;
            cur = next;
            next = next.next;
        }
        return head;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
