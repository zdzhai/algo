package com.yugutou.charpter1_linklist.level2.topic2_2回文序列;

import java.util.Stack;

/***
 * 判断链表是否回文
 */

/**
 * 思路：
 * 1. 双指针前后指针 但是取到后指针本身就已经O(n)，忽略常数依然时O(n)
 * 2. 快慢（1，2）指针找到中间节点，可以满足O(n)
 * 3. 队列，左右同时出队列
 * 4. 数组同理，遍历一遍放到数组，然后双指针
 *
 * 5. 栈，压栈后出栈并和链表中的元素相比较，只要不一致就false
 * 6. 优化5.全部压栈，只比较栈和链表中一半的元素
 * 7. 反转链表 构建新链表对原链表节点进行反转，反转一半后，进行逐个对比
 * @author zdzhai
 */
public class IsPalindromic {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 4, 3, 2, 1};
        ListNode node = initLinkedList(a);
        int testMethod = 1;
        boolean result = false;
        switch (testMethod) {
            case 1://方法1：通过双指针的方式来判断
                result = isPalindromeByTwoPoints(node);
                break;
            case 2: //方法2：全部压栈
                result = isPalindromeByAllStack(node);
                break;
            case 3://方法3：只将一半的数据压栈
                result = isPalindromeByHalfStack(node);
                break;
            case 4://方法4：通过递归来实现
                result = isPalindromeByRe(node);
                break;

        }
        System.out.println("result:" + result);
    }


    /**
     * 方法1：通过双指针的方式来判断
     *
     * @param head
     * @return
     */
    public static boolean isPalindromeByTwoPoints(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = head;
        ListNode prePre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prePre;
            prePre = pre;
        }
        while (pre != null && slow != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }

    /**
     * 方法2：全部压栈
     *
     * @param head
     * @return
     */
    public static boolean isPalindromeByAllStack(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while (!stack.isEmpty()) {
            if (stack.pop() != temp.val) {
                return false;
            } else {
                temp = temp.next;
            }
        }
        return true;
    }

    /**
     * 方法3：只将一半的数据压栈
     *
     * @param head
     * @return
     */
    public static boolean isPalindromeByHalfStack(ListNode head) {
        if (head == null)
            return true;
        ListNode temp = head;
        Stack<Integer> stack = new Stack();
        //链表的长度
        int len = 0;
        //把链表节点的值存放到栈中
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
            len++;
        }
        //len长度除以2
        len >>= 1;
        //然后再出栈
        while (len-- >= 0) {
            if (head.val != stack.pop())
                return false;
            head = head.next;
        }
        return true;
    }

    /**
     * 方法4：通过递归来实现
     */
    static ListNode temp;
    public static boolean isPalindromeByRe(ListNode head) {
        temp = head;
        return check(head);
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

    private static boolean check(ListNode head) {
        if (head == null)
            return true;
        boolean res = check(head.next) && (temp.val == head.val);
        temp = temp.next;
        return res;
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
