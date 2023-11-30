package com.yugutou.charpter8_tree_hot_problems.level1.topic_路径专题;

import com.yugutou.tools.BinaryTree;
import com.yugutou.tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode257 二叉树的所有路径
 */
public class BinaryTreePaths {
    public static void main(String[] args) {
         BinaryTree bTree = new BinaryTree();
        bTree.root = bTree.buildBinaryTree();
        List<String> result = binaryTreePaths(bTree.root);
        System.out.println(result);
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, "", res);
        return res;
    }

    /**
     *
     * @param root
     * @param path
     * @param res
     */
    private static void dfs(TreeNode root, String path, List<String> res) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            path += root.val;
            res.add(path);
            return;
        }
        path += root.val;
        dfs(root.left, path + "->", res);
        dfs(root.right, path+ "->", res);
    }
}
