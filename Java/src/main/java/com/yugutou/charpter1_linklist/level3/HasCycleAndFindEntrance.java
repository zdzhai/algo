package com.yugutou.charpter1_linklist.level3;

import com.yugutou.charpter1_linklist.level3.HasCycleAndFindEntrance.ListNode;

import java.util.HashSet;
import java.util.Set;

public class HasCycleAndFindEntrance {
    /**
     * 是否存在环,如果存在环，要返回入口
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        ListNode nodeA = null;

        //构造链表是否存在环
        int isCycle = 1;
        switch (isCycle) {
            case 1://构造的链表中存在环
                nodeA = initLinkedListHasCycle(a);
                break;
            case 2://构造的链表中不存在环
                nodeA = initLinkedList(a);
                break;
        }


        //测试哪个方法
        int testmethod = 2;
        ListNode result = null;
        switch (testmethod) {
            case 1:
                result = detectCycleByMap(nodeA);
                break;
            case 2:
                result = detectCycleByTwoPoint(nodeA);
                break;
        }

        System.out.println(result.val);

    }

    /**
     * 方法1：通过HashMap或者实现
     * 遇到重复的第一个元素，就是入口元素
     * @param head
     * @return
     */
    public static ListNode detectCycleByMap(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return null;
    }



    /**
     * 方法2 通过双指针实现
     * 快慢指针先确定成环，在交集处以及head放两个指针，同时一部前进，交汇处为入口节点。
     *
     * @param head
     * @return
     */

    public static ListNode detectCycleByTwoPoint(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        ListNode pNode = null;
        while (fast !=  null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                pNode = slow;
                break;
            }
        }
        if (pNode != null) {
            while (head != null){
                head = head.next;
                pNode = pNode.next;
                if (pNode == head) {
                    return head;
                }
            }
        }
        return null;
    }



    /**
     * 初始化链表
     *
     * @param array
     * @return
     */
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

    /**
     * 构造存在环的情况
     *
     * @param array
     * @return
     */
    private static ListNode initLinkedListHasCycle(int[] array) {
        ListNode head = null, cur = null;
        ListNode cross = null;
        for (int i = 0; i < array.length; i++) {
            ListNode newNode = new ListNode(array[i]);
            newNode.next = null;
            if (i == 0) {
                head = newNode;
                cur = head;
            } else {
                cur.next = newNode;
                cur = newNode;
                //找到中间位置结点
                if (i == array.length / 2) {
                    cross = cur;
                }
            }
        }
        //制造环
        cur.next = cross;
        return head;
    }

    /**
     * 输出链表
     *
     * @param head 头节点
     */
    public static String toString(ListNode head) {
        ListNode current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.val).append("\t");
            current = current.next;
        }
        return sb.toString();
    }

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
