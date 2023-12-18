package com.yugutou.charpter1_linklist.level1;

/**
 * @author dongdong
 * @Date 2023/12/16 23:12
 */
public class DeleteDuplicates {
    public static void main(String[] args) {

    }
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        while (node.next != null) {
            if (node.next.val == node.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }
}
