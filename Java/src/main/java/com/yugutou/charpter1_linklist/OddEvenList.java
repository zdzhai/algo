package com.yugutou.charpter1_linklist;

import com.yugutou.charpter1_linklist.level1.ListNode;
import com.yugutou.tools.InitLinkedList;

/**
 * leetcode 328. 奇偶链表
 * @author dongdong
 * @Date 2024/1/16 19:49
 */
public class OddEvenList {
    public static void main(String[] args) {
        int[] nums = {2,1,3,5,6,4,7};
        ListNode listNode = InitLinkedList.initLinkedList(nums);
        ListNode resNode = oddEvenList(listNode);
        InitLinkedList.printLinkedList(resNode);
    }

    /**
     * 方法1：遍历一遍，构建两个新链表，奇偶一次添加
     * @param head
     * @return
     */
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = new ListNode(-1), even = new ListNode(-1);
        ListNode t1 = odd, t2 = even;
        while (head != null && head.next != null) {
            t1.next = head;
            t2.next = head.next;
            t1 = t1.next;
            t2 = t2.next;
            head = head.next.next;
        }
        if (head != null) {
            t1.next = head;
            t1 = t1.next;
        }
        t2.next = null;
        t1.next = even.next;
        return odd.next;
    }
}
