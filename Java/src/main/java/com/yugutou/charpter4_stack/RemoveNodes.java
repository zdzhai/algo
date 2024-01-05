package com.yugutou.charpter4_stack;

import com.yugutou.charpter1_linklist.level1.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author dongdong
 * @Date 2024/1/4 14:29
 */
public class RemoveNodes {
    public static void main(String[] args) {
        int[] nums = {14,2,13,3,8};
        ListNode listNode = initLinkedList(nums);
        ListNode ans = removeNodes(listNode);
        System.out.println(ans);
    }

    /**
     * 使用单调栈，
     * @param head
     * @return
     */
    public static ListNode removeNodes(ListNode head) {
        Deque<ListNode> stack = new LinkedList<>();
        ListNode ans = null;
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        while (!stack.isEmpty()) {
            ListNode peek = stack.pop();
            if (ans == null) {
                ans = peek;
            }
            else if (peek.val >= ans.val) {
                peek.next = ans;
                ans = peek;
            }
        }
        return ans;
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
