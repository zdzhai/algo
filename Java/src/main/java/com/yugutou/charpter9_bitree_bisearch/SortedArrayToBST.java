package com.yugutou.charpter9_bitree_bisearch;

import com.yugutou.tools.TreeNode;

/**
 * leetcode 108. 将有序数组转换为BST
 * @author dongdong
 * @Date 2024/1/8 20:45
 */
public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        System.out.println(sortedArrayToBST(nums));
    }

    /**
     * 二叉搜索树的特点是中序遍历就是升序
     * 二叉搜索树的查找就是二分查找，所以构建也使用二分构建
     * @param nums
     * @return
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        return inOrder(nums, 0, nums.length - 1);
    }

    public static TreeNode inOrder(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (( right - left) >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = inOrder(nums, left, mid - 1);
        root.right = inOrder(nums, mid + 1, right);
        return root;
    }
}
