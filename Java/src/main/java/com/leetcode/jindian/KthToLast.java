package com.leetcode.jindian;

import com.yugutou.charpter1_linklist.level1.ListNode;

import static com.yugutou.tools.InitLinkedList.initLinkedList;

/**
 * @author dongdong
 * @Date 2024/8/15 21:59
 * 面试题02.02.返回倒数第k个节点
 */
public class KthToLast {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        ListNode node = initLinkedList(a);

        System.out.println(kthToLast(node, 2));
    }

    /**
     * 使用快慢指针
     * 快指针先走k个节点，然后再一起走，快指针走完时候，慢指针
     * -1 -> 1 -> 2 -> 3 -> 4 -> 5
     *                 2
     *
     *  时间复杂度O(n)
     *  空间复杂度O(1)
     * @param head
     * @param k
     * @return
     */
    public static int kthToLast(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }
}
