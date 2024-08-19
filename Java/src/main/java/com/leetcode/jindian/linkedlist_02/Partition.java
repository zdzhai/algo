package com.leetcode.jindian.linkedlist_02;

import com.yugutou.charpter1_linklist.level1.ListNode;

import static com.yugutou.tools.InitLinkedList.initLinkedList;

/**
 * @author dongdong
 * @Date 2024/8/18 14:32
 * 面试题02.04.分割链表
 */
public class Partition {
    public static void main(String[] args) {
        int[] a = {1,4,3,2,5,2};
        ListNode node = initLinkedList(a);
        System.out.println(partition(node, 3));
    }

    /**
     * 遍历找到 第一个 大于等于目标值的节点作为定位并记录前驱节点
     * 继续遍历，把小于目标节点的节点，先记录其后继节点，然后再放在上述前驱节点的后边。
     * 时间复杂度O(n)
     *
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy, curr = head;
        ListNode front = head;
        while (curr != null) {
            if (curr.val >= x) break;
            prev = curr;
            front = curr;
            curr = curr.next;
        }

        while (curr != null) {
            if (curr.val < x) {
                front.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;

                prev = prev.next;
            }
            front = curr;
            curr = curr.next;
        }
        return dummy.next;
    }


}
