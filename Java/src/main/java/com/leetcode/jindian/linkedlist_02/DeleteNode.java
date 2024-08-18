package com.leetcode.jindian.linkedlist_02;

import com.yugutou.charpter1_linklist.level1.ListNode;

import static com.yugutou.tools.InitLinkedList.initLinkedList;

/**
 * @author dongdong
 * @Date 2024/8/18 14:05
 * 面试题02.03.删除中间节点
 */
public class DeleteNode {

    public static void main(String[] args) {
        int[] a = {2,0,1,3};
        ListNode node = initLinkedList(a);
        deleteNode(node);

    }

    /**
     * 遍历找到该节点，要注意不只是值相同，节点也要是相同的
     * 记录前驱节点，将前驱节点向后指就可以
     * 4->5->1->9
     * 4->1->9
     * 时间复杂度O(n)
     * @param node
     */
    public static void deleteNode(ListNode node) {
        while (node.next.next != null) {
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }
}
