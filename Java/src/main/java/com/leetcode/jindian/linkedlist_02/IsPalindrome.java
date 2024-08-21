package com.leetcode.jindian.linkedlist_02;

import com.yugutou.charpter1_linklist.level1.ListNode;

import static com.yugutou.tools.InitLinkedList.initLinkedList;

/**
 * @author dongdong
 * @Date 2024/8/20 22:25
 * 面试题02.06.回文链表
 */
public class IsPalindrome {
    public static void main(String[] args) {
        int[] a = {};
        ListNode node = initLinkedList(a);
        System.out.println(isPalindrome(node));
    }

    /**
     * 可以先反转链表，然后再同步遍历，出现不一致就false
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     * 思路二：
     * 先遍历一遍链表，明确其长度，然后二次遍历
     * 二次遍历过程中，把前半部分链表做反转，到中间节点时，同时遍历两侧
     * 出现不一致就false
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode node = head.next;
        ListNode prev = new ListNode(head.val), curr = new ListNode(node.val);
        prev.next = null;
        while (node.next != null) {
            ListNode temp = new ListNode(node.next.val);
            curr.next = prev;
            prev = curr;
            curr = temp;
            node = node.next;
        }
        curr.next = prev;

        ListNode l1 = head;
        ListNode l2 = curr;

        while (l1 != null) {
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }

        return true;
    }
}
