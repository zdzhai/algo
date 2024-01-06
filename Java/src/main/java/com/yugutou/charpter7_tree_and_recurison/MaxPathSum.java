package com.yugutou.charpter7_tree_and_recurison;

import com.yugutou.tools.TreeNode;

/**
 * leetcode 124. 二叉树中的最大路径和
 * @author dongdong
 * @Date 2024/1/6 13:32
 */
public class MaxPathSum {
    public static void main(String[] args) {

    }

    /**
     * 中序遍历
     * 以每个非叶子节点开始的中序遍历，求最大路径和
     * @param root
     * @return
     */
    static int ans = 0;
    public static int maxPathSum(TreeNode root) {
        ans = -1001;
        midOrder(root);
        return ans;
    }

    /**
     * 得到左右子树的结果，判断只使用根节点，左右子树最大值+根节点哪个更大，返回给上层
     * 在dfs过程中，记录以当前节点为根节点时的最大路径和。
     * 返回以该节点延申往下的最大路径和
     * @param root
     * @return
     */
    public static int midOrder(TreeNode root) {
        if (root == null) return 0;
        int left = midOrder(root.left);
        int right = midOrder(root.right);
        int t = root.val;
        if (left >= 0) t += left;
        if (right >= 0) t += right;
        ans = Math.max(ans, t);
        return Math.max(root.val, Math.max(left, right) + root.val);
    }

}
