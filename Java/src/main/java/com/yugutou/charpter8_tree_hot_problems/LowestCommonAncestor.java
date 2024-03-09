package com.yugutou.charpter8_tree_hot_problems;

import com.yugutou.tools.BinaryTree;
import com.yugutou.tools.TreeNode;

/**
 * leetcode 235.二叉搜索树的最近公共祖先
 * @author dongdong
 * @Date 2024/1/2 14:31
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode treeNode = BinaryTree.buildBSTTree();

        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(7);
        //TreeNode resNode = lowestCommonAncestor(treeNode, treeNode.right, treeNode.left.left);
        TreeNode resNode = lowestCommonAncestor2(treeNode, p, q);
        System.out.println(resNode.val);

    }

    /**
     * 如果是普通的二叉树
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
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    /**
     * 如果是二叉搜索树
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor2(root.right, p, q);
        }
        else if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor2(root.left, p, q);
        }
        return root;
    }
}
