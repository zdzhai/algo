package com.yugutou.charpter8_tree_hot_problems;

import com.yugutou.tools.TreeNode;

/**
 * leetcode 938.二叉搜索树的范围和
 * @author dongdong
 * @Date 2024/2/26 22:11
 */
public class RangeSumBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        root.right = new TreeNode(15);
        root.right.right = new TreeNode(18);

        RangeSumBST rangeSumBST = new RangeSumBST();
        System.out.println(rangeSumBST.rangeSumBST(root, 7, 15));
    }

    /**
     * 中序遍历二叉搜索树，把符合范围的值进行累加
     * @param root
     * @param low
     * @param high
     * @return
     */
    int ans = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        rangeSumBST(root.left, low, high);
        if (root.val >= low && root.val <= high) {
            ans += root.val;
        }
        rangeSumBST(root.right, low, high);
        return ans;
    }
}
