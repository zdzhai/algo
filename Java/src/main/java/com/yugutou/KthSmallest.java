package com.yugutou;

import com.yugutou.tools.BinaryTree;
import com.yugutou.tools.TreeNode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * leetcode 230. 二叉搜索树中第K小的元素
 * @author dongdong
 * @Date 2023/12/28 10:11
 */
public class KthSmallest {
    public static void main(String[] args) {
        TreeNode treeNode = BinaryTree.buildBSTTree();
        System.out.println( kthSmallest(treeNode, 3));
        System.out.println( kthSmallest2(treeNode, 3));
    }

    /**
     * 使用优先队列
     * k个大小的优先队列，大顶堆
     * @param root
     * @param k
     * @return
     */
    public static int kthSmallest(TreeNode root, int k) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        preOrder(root, pq, k);
        return pq.peek();
    }

    public static void preOrder(TreeNode root, Queue<Integer> pq, int k) {
        if (root == null) {
            return;
        }
        if (pq.size() < k) {
            pq.add(root.val);
        }
        else if (root.val < pq.peek()) {
            pq.poll();
            pq.offer(root.val);
        }
        preOrder(root.left, pq, k);
        preOrder(root.right, pq, k);
    }

    /**
     * 因为是二叉搜索树
     * 所以中序遍历就是升序的
     * 记录遍历序号，到达k直接返回
     * @param root
     * @param k
     * @return
     */
    static int res, count;
    public static int kthSmallest2(TreeNode root, int k) {
        res = 0;
        count = k;
        midOrder(root);
        return res;
    }

    /**
     * 左中右
     * @param root
     */
    public static void midOrder(TreeNode root) {
        if (root == null) return;
        midOrder(root.left);
        if (--count == 0) {
            res = root.val;
        }
        midOrder(root.right);
    }
}
