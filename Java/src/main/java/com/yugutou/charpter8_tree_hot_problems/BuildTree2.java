package com.yugutou.charpter8_tree_hot_problems;

import com.yugutou.tools.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 106. 从中序遍历和后序遍历恢复二叉树
 * @author dongdong
 * @Date 2024/2/21 9:58
 */
public class BuildTree2 {
    public static void main(String[] args) {

    }

    Map<Integer, Integer> inMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            inMap.put(inorder[i], i);
        }

        return build(inorder, postorder, 0, n - 1, 0, n - 1);
    }

    /**
     * 中序 左中右
     * 后续 左右中
     * @param inorder
     * @param postorder
     * @param in_l
     * @param in_r
     * @param post_l
     * @param post_r
     * @return
     */
    private TreeNode build(int[] inorder,
                           int[] postorder,
                           int in_l, int in_r,
                           int post_l, int post_r) {
        if (post_l > post_r) return null;
        int root_val = postorder[post_r];
        int root_idx = inMap.get(root_val);
        TreeNode root = new TreeNode(root_val);
        int subLen = root_idx - in_l;
        root.left = build(inorder, postorder, in_l, root_idx - 1, post_l, post_l + subLen - 1);
        root.right = build(inorder, postorder, root_idx + 1, in_r, post_l + subLen, post_r - 1);
        return root;
    }
}
