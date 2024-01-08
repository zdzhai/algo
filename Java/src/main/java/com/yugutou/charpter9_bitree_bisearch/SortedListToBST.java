package com.yugutou.charpter9_bitree_bisearch;

import com.yugutou.charpter1_linklist.level1.ListNode;
import com.yugutou.tools.InitLinkedList;
import com.yugutou.tools.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author dongdong
 * @Date 2024/1/8 21:19
 */
public class SortedListToBST {
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        ListNode listNode = InitLinkedList.initLinkedList(nums);
        System.out.println(sortedListToBST(listNode));
    }

    public static TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new LinkedList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return dfs(list, 0, list.size() - 1);
    }

    /**
     * 单向链表的问题在于无法正反向根据索引获取元素
     * 这里可以将链表放在list列表中做索引获取
     * @param list
     * @return
     */
    public static TreeNode dfs(List<Integer> list, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (( right - left ) >> 1);
        TreeNode root = new TreeNode(list.get(mid));
        root.left = dfs(list, left, mid - 1);
        root.right = dfs(list, mid + 1, right);
        return root;
    }
}
