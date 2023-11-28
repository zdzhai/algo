package com.yugutou.charpter6_tree_level_travel.level2;
import com.yugutou.tools.BinaryTree;
import com.yugutou.tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode102 题目要求：
 * 给你一个二叉树，请你返回其按层序遍历得到的节点值。
 * (即逐层地，从左到右访问所有节点)。
 */
public class Level102Order {
    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree();
        bTree.root = bTree.buildBinaryTree();
        List<List<Integer>> level = level102Order(bTree.root);
        System.out.println(level.toString());
    }

    /**
     * 在每层的遍历之前先获取一下当前的元素个数，也就是上一层的元素个数
     * @param root
     * @return
     */
    public static List<List<Integer>> level102Order(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                TreeNode node = queue.remove();
                list.add(node.val);
                size--;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}

