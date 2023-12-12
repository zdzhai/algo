package com.yugutou.charpter14_heap.level2;

import com.yugutou.charpter1_linklist.level1.ListNode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author dongdong
 * @Date 2023/12/11 20:05
 */
public class MergeKLinkedList {
    public static void main(String[] args) {

    }

    /**
     * 使用小顶堆来做
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;
        Queue<ListNode> pq = new PriorityQueue<>(size, (node1,node2) -> node1.val - node2.val);
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            tail.next = node;
            tail = node;
            if (node.next != null) {
                pq.offer(node.next);
            }
        }
        return dummy.next;
    }
}
