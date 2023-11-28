package com.yugutou.charpter6_tree_level_travel.level2;

import com.yugutou.tools.BinaryTree;
import com.yugutou.tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  LeetCode 199题目要求:
 *  给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，
 *  返回从右侧所能看到的节点值。
 */
public class RightSideView {
    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree();
        bTree.root = bTree.buildBinaryTree();
        List<Integer> level = leftSideView(bTree.root);
        System.out.println(level.toString());
    }

    /**
     * 找每行的最后一个元素
     * @param root
     * @return
     */
    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int right = 0;
            while (size > 0) {
                TreeNode node = queue.remove();
                if (size == 1) {
                    right = node.val;
                }
                size--;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.add(right);
        }
        return ans;
    }

    public static List<Integer> leftSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int right = 0;
            while (size > 0) {
                TreeNode node = queue.remove();
                if (size == 1) {
                    right = node.val;
                }
                size--;
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }

            }
            ans.add(right);
        }
        return ans;
    }
}

