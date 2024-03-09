package com.yugutou.charpter8_tree_hot_problems;

import com.yugutou.tools.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 889.根据前序和后序遍历构造二叉树
 * @author dongdong
 * @Date 2024/2/22 22:56
 */
public class ConstructFromPrePost {

    public static void main(String[] args) {

    }
    Map<Integer, Integer> postMap = new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            postMap.put(postorder[i], i);
        }
        return build(preorder, postorder, 0, n - 1, 0, n - 1);
    }

    /**
     *
     * @param preorder
     * @param postorder
     * @param pre_l
     * @param pre_r
     * @param post_l
     * @param post_r
     * @return
     */
    private TreeNode build(int[] preorder, int[] postorder,
                           int pre_l, int pre_r,
                           int post_l, int post_r) {
        if (pre_l > pre_r) return null;
        int subLen = 0;
        if (pre_l < pre_r) {
            int root_idx = postMap.get(preorder[pre_l + 1]);
            subLen = root_idx - post_l + 1;
        }
        TreeNode root = new TreeNode(preorder[pre_l]);
        root.left = build(preorder, postorder, pre_l + 1, pre_l + subLen, post_l, post_l + subLen - 1);
        root.right = build(preorder, postorder, pre_l + subLen + 1, pre_r, post_l + subLen, post_r - 1);
        return root;
    }


}
