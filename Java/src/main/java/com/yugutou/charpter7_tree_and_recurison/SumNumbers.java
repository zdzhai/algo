package com.yugutou.charpter7_tree_and_recurison;

import com.yugutou.tools.TreeNode;

/**
 * leetcode 129. 求根节点到叶节点数字之和
 * @author dongdong
 * @Date 2024/1/6 19:33
 */
public class SumNumbers {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        System.out.println(sumNumbers(root));
    }

    /**
     * 中序遍历到叶子节点
     * @param root
     * @return
     */
    static int ans = 0;
    static StringBuilder sb = new StringBuilder();
    public static int sumNumbers(TreeNode root) {
        ans = 0;
        sb = new StringBuilder();
        return dfs(root, 0);
    }

    public static void dfs(TreeNode root) {
        if (root == null) return;
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            ans += Integer.parseInt(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        dfs(root.left);
        dfs(root.right);
        sb.deleteCharAt(sb.length() - 1);
    }

    public static int dfs(TreeNode root, int temp) {
        temp = temp * 10 + root.val;
        if (root.left == null && root.right == null) {
            return temp;
        }
        int left = 0, right = 0;
        if (root.left != null) {
            left = dfs(root.left, temp);
        }
        if (root.right != null) {
            right = dfs(root.right, temp);
        }
        return left + right;
    }
}
