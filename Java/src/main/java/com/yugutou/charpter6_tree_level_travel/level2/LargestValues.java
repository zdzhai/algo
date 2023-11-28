package com.yugutou.charpter6_tree_level_travel.level2;

import com.yugutou.tools.BinaryTree;
import com.yugutou.tools.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * LeetCode 515题目要求：
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 */
public class LargestValues {
    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree();
        bTree.root = bTree.buildBinaryTree();
        List<Integer> level = largestValues(bTree.root);
        System.out.println(level.toString());
    }

    /**
     * 遍历每层的时候找到最大值
     * @param root
     * @return
     */
    public static List<Integer> largestValues(TreeNode root) {
       if (root == null) {
           return new ArrayList<>();
       }
       List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            while (size > 0) {
                TreeNode node = queue.remove();
                size--;
                max = Math.max(max, node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.add(max);
        }
        return ans;
    }
}

