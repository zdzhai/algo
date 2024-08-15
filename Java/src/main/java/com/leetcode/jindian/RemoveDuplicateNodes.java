package com.leetcode.jindian;

import com.yugutou.charpter1_linklist.level1.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dongdong
 * @Date 2024/8/12 22:06
 * 面试题02.01.移除重复节点
 */
public class RemoveDuplicateNodes {
    public static void main(String[] args) {
        int[] a = {1,1,1,1,2};
        ListNode node = initLinkedList(a);

        System.out.println(removeDuplicateNodes(node));
    }


    /**
     *
     * @param head
     * @return
     */
    public static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        Set<Integer> set = new HashSet<>();
        while (cur != null) {
            if (!set.contains(cur.val)) {
                set.add(cur.val);
                pre.next = cur;
                pre = pre.next;
            }
            cur = cur.next;
        }
        pre.next = null;
        return dummy.next;
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