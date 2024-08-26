package com.leetcode.jindian.linkedlist_02;

import com.yugutou.charpter1_linklist.level1.ListNode;

import java.util.HashSet;
import java.util.Set;

import static com.yugutou.tools.InitLinkedList.initLinkedList;

/**
 * @author dongdong
 * @Date 2024/8/26 22:26
 * 面试题02.07.链表相交
 */
public class GetIntersectionNode {
    public static void main(String[] args) {
        int[] a = {4,1,8,4,5};
        int[] b = {5,0,1,8,4,5};
        ListNode nodeA = initLinkedList(a);
        ListNode nodeB = initLinkedList(b);
        System.out.println(getIntersectionNode(nodeA, nodeB) == null ? "null" : getIntersectionNode(nodeA, nodeB).val);
        System.out.println(getIntersectionNode2(nodeA, nodeB) == null ? "null" : getIntersectionNode2(nodeA, nodeB).val);
    }

    /**
     * 两个链表都先反向，然后再遍历，第一个不一样的节点的前节点就是相交节点，但是此方法会改变链表结构
     *
     * 把其中一个链表的结果缓存起来，遍历另一个，第一个存在的就是相交节点
     * 时间复杂度O(m+n)
     * 空间复杂度O(n)
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        Set<ListNode> set = new HashSet<>();
        ListNode cur = headA;
        while (cur != null) {
            set.add(cur);
            cur = cur.next;
        }
        cur = headB;
        while (cur != null) {
            if (set.contains(cur)) return cur;
            cur = cur.next;
        }
        return null;
    }

    /**
     * 1 短链表，2 长链表
     * 时间复杂度O(m+n)
     * 空间复杂度O(1)
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        int length1 = 0;
        int length2 = 0;
        while (cur1 != null) {
            length1++;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            length2++;
            cur2 = cur2.next;
        }

        int diff = length2 - length1;
        cur1 = headA;
        cur2 = headB;

        if (length1 > length2) {
            cur1 = headB;
            cur2 = headA;
            diff = -diff;
        }
        while (diff > 0) {
            cur2 = cur2.next;
            diff--;
        }
        while (cur1 != null && cur2 != null) {
            if (cur1 == cur2) {
                return cur1;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return null;
    }
}
