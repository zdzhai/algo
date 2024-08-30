package com.leetcode.jindian.linkedlist_02;

import com.yugutou.charpter1_linklist.level1.ListNode;

import static com.yugutou.tools.InitLinkedList.initLinkedList;

/**
 * @author dongdong
 * @Date 2024/8/29 22:23
 */
public class DetectCycle {
    public static void main(String[] args) {
        int[] a = {1,4,3,2,5,2};
        ListNode node = initLinkedList(a);
    }


    /**
     * 快慢指针，相遇处就是环的入口
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode meet = null;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                meet = slow;
                break;
            }
        }
        slow = head;
        if (slow == meet) return meet;

        while (slow != null && meet != null) {
            slow = slow.next;
            meet = meet.next;
            if (meet == slow) {return meet;}
        }
        return null;
    }
}
