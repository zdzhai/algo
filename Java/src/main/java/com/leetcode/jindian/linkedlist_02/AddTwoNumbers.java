package com.leetcode.jindian.linkedlist_02;

import com.yugutou.charpter1_linklist.level1.ListNode;

import static com.yugutou.tools.InitLinkedList.initLinkedList;

/**
 * @author dongdong
 * @Date 2024/8/20 21:45
 * 面试题02.05.链表求和
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        int[] a = {1};
        int[] b = {9,9,9};
        ListNode l1 = initLinkedList(a);
        ListNode l2 = initLinkedList(b);
        System.out.println(addTwoNumbers(l1, l2));
    }

    /**
     * 单独记录进位
     * 两个指针同时走，任意一个为空则判断进位，然后继续往后走
     * 时间复杂度O(m+n)
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(-1);
        dummy.next = l1;
        ListNode head1 = l1;
        ListNode head2 = l2;

        while (head1 != null && head2 != null) {
            head1 = head1.next;
            head2 = head2.next;
        }

        //head1为长链表
        if (head2 != null) {
            head1 = l2;
            head2 = l1;
            dummy.next = l2;
        } else {
            head1 = l1;
            head2 = l2;
        }

        ListNode prev = dummy;
        int carry = 0;
        int sum = 0;
        while (head1 != null && head2 != null) {
            sum = head1.val + head2.val + carry;
            if (sum > 9) carry = 1;
            else carry = 0;
            head1.val = sum % 10;

            head1 = head1.next;
            prev = prev.next;
            head2 = head2.next;
        }
        while (head1 != null) {
            sum = head1.val + carry;
            if (sum > 9) carry = 1;
            else carry = 0;
            head1.val = sum % 10;

            head1 = head1.next;
            prev = prev.next;
        }
        if (carry == 1) {
            prev.next = new ListNode(1);
        }

        return dummy.next;
    }

}
