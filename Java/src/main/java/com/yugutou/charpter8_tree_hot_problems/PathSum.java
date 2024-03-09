package com.yugutou.charpter8_tree_hot_problems;

import com.yugutou.tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 437.路径总和3
 * @author dongdong
 * @Date 2024/2/29 19:10
 */
public class PathSum {
    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);

        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);*/
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(-1);

        root.right = new TreeNode(-3);
        root.right.left = new TreeNode(-2);

        PathSum pathSum = new PathSum();
        System.out.println(pathSum.pathSum(root, 1));
    }

    /**
     * 从任意节点起回溯
     * @param root
     * @param targetSum
     * @return
     */
    int ans = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            dfs(node, targetSum, 0);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return ans;
    }

    public void dfs(TreeNode root, int targetNum, long sum) {
        if (root == null) return;
        //if (targetNum > 0 && sum > targetNum) return;
        //if (targetNum < 0 && sum < targetNum) return;
        sum += root.val;
        if (sum == targetNum) {
            ans++;
        }
        dfs(root.left, targetNum, sum);
        dfs(root.right, targetNum, sum);
    }
}
