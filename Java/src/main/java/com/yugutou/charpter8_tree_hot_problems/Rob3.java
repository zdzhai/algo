package com.yugutou.charpter8_tree_hot_problems;

import com.yugutou.tools.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 337.打家劫舍3
 * @author dongdong
 * @Date 2024/3/9 19:29
 */
public class Rob3 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(3);
        root.right.right = new TreeNode(1);

        Rob3 rob3 = new Rob3();
        System.out.println(rob3.rob(root));
    }

    /**
     * 打劫root节点，则左右子树不能打劫，其val为根节点值
     * 不打劫root节点，则左右子树都可以打劫，其val为相加
     *
     * @param root
     * @return
     */
    Map<TreeNode, Integer> cache = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (cache.containsKey(root)) return cache.get(root);
        int val1 = root.val;
        if (root.left != null) {
            val1 += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            val1 += rob(root.right.left) + rob(root.right.right);
        }
        int val2 = rob(root.left) + rob(root.right);
        int result = Math.max(val1,val2);
        cache.put(root, result);
        return result;
    }

    public int rob2(TreeNode root) {
        int[] result = helper(root);
        return Math.max(result[0], result[1]);
    }

    /**
     * money[]数组表示任意一个节点能偷到的最大钱，但不一定该节点必须要偷
     *
     * @param root
     * @return
     */
    private int[] helper(TreeNode root) {
        if (root == null) return new int[2];
        int[] money = new int[2];

        int[] left = helper(root.left);
        int[] right = helper(root.right);
        //0表示当前节点不偷 左右节点能偷到的最大钱
        money[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //偷当前节点，不偷左右节点
        money[1] = root.val + left[0] + right[0];

        return money;
    }
}
