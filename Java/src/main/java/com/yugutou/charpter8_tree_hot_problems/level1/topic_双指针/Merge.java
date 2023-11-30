package com.yugutou.charpter8_tree_hot_problems.level1.topic_双指针;

import com.yugutou.tools.BinaryTree;
import com.yugutou.tools.TreeNode;

/**
 * LeetCode617 合并两个二叉树
 */
public class Merge {
    public static void main(String[] args) {
        BinaryTree bTree1 = new BinaryTree();
        bTree1.root = bTree1.buildBinaryTree();

        BinaryTree bTree2 = new BinaryTree();
        bTree2.root = bTree2.buildBinaryTree();

        TreeNode newTree = mergeTrees(bTree1.root, bTree2.root);
        System.out.println(newTree.val);

    }

    /**
     * LeetCode617 合并两个二叉树
     * 两树的节点都不为空，相加节点的值
     * 左为空右不为空，为右节点的值
     * 左不为空右为空，为左节点的值
     * 过程和二叉树的中序遍历很相似
     * @param t1
     * @param t2
     * @return
     */
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 != null && t2 == null) {
            return t1;
        }
        if (t1 == null && t2 != null) {
            return t2;
        }
        TreeNode newNode = new TreeNode(t1.val + t2.val);
        newNode.left = mergeTrees(t1.left, t2.left);
        newNode.right = mergeTrees(t1.right, t2.right);
        return newNode;
    }

}
