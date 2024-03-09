package com.yugutou.charpter8_tree_hot_problems;

import com.yugutou.tools.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * leetcode 2583.二叉树中的第K大层和
 * @author dongdong
 * @Date 2024/2/23 21:20
 */
public class KthLargestLevelSum {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(8);
        node.left.left = new TreeNode(2);
        node.left.right = new TreeNode(1);
        node.left.left.left = new TreeNode(4);
        node.left.left.right = new TreeNode(6);

        node.right = new TreeNode(9);
        node.right.left = new TreeNode(3);
        node.right.right = new TreeNode(7);

        KthLargestLevelSum kthLargestLevelSum = new KthLargestLevelSum();

        System.out.println(kthLargestLevelSum.kthLargestLevelSum(node, 2));
    }

    /**
     * 先层序遍历得到每层的和
     * 使用小顶堆得到第K大值
     * 时间复杂度O(nlogk)
     * @param root
     * @param k
     * @return
     */
    public long kthLargestLevelSum(TreeNode root, int k) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root);

        PriorityQueue<Long> pq = new PriorityQueue<>(k);

        while (!deque.isEmpty()) {
            int size = deque.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.removeLast();
                sum += node.val;
                if (node.left != null) deque.addFirst(node.left);
                if (node.right != null) deque.addFirst(node.right);
            }
            pq.add(sum);
            if (pq.size() > k) pq.remove();
        }
        return pq.size() < k ? -1 : pq.peek();
    }
}
