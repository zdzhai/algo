package com.yugutou.charpter8_tree_hot_problems;

import com.yugutou.tools.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 105. 从前序遍历和中序遍历恢复二叉树
 * @author dongdong
 * @Date 2024/2/20 23:50
 */
public class BuildTree {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        BuildTree buildTree = new BuildTree();
        TreeNode treeNode = buildTree.buildTree(preorder, inorder);
    }

    /**
     * 前序遍历 中左右 前序遍历的第一个元素是中序遍历的中间元素
     * 中序遍历 左中右
     * @param preorder
     * @param inorder
     * @return
     */
    Map<Integer, Integer> in = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < preorder.length; i++) {
            in.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode build(int[] preorder,
                           int[] inorder,
                           int pre_l, int pre_r,
                           int in_l, int in_r) {
        if (pre_l > pre_r) return null;
        int root_val = preorder[pre_l];
        int root_idx = in.get(root_val);
        TreeNode root = new TreeNode(root_val);
        int size_sub_tree = root_idx - in_l;
        root.left = build(preorder, inorder, pre_l + 1, pre_l + size_sub_tree, in_l, root_idx - 1);
        root.right = build(preorder, inorder, pre_l + size_sub_tree + 1, pre_r, root_idx + 1, in_r);
        return root;
    }


}
