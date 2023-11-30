package com.yugutou.charpter8_tree_hot_problems.level3;

import com.yugutou.tools.BinaryTree;
import com.yugutou.tools.TreeNode;

/**
 * LeetCode 236 二叉树的最近公共祖先
 */
public class CommonAncestor {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = binaryTree.buildBinaryTree();

        TreeNode node = lowestCommonAncestor(binaryTree.root, binaryTree.root.right.right, binaryTree.root.left);
        System.out.println(node.val);

    }

    /**
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        /*if (left == null && right == null) {
            return null;
        }*/
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }


}
