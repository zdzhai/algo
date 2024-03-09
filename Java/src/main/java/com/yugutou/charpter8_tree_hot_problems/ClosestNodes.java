package com.yugutou.charpter8_tree_hot_problems;

import com.yugutou.tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 2476.二叉搜索树最近节点查询
 * @author dongdong
 * @Date 2024/2/24 10:57
 */
public class ClosestNodes {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(13);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(15);
        root.right.right.left = new TreeNode(14);

        List<Integer> query = new ArrayList<>();
        query.add(2);
        query.add(5);
        query.add(16);
        ClosestNodes closestNodes = new ClosestNodes();

        System.out.println(closestNodes.closestNodes(root, query));
    }

    /**
     * 使用二叉搜索树的中序遍历得到升序数组
     * 然后依次使用二分查找小于等于target的最大值和大于等于target的最小值
     * @param root
     * @param queries
     * @return
     */
    List<Integer> list = new ArrayList<>();
    int[] arr;
    int i = 0;
    public List<List<Integer>> closestNodes(TreeNode root,
                                            List<Integer> queries) {
        List<List<Integer>> res = new ArrayList<>();
        inorder(root);
        arr = new int[list.size()];
        for (Integer num : list) {
            arr[i++] = num;
        }
        int n = arr.length;
        for (Integer query : queries) {
            int max = searchMax(arr, 0, n - 1, query);
            int min = searchMin(arr, 0, n - 1, query);
            List<Integer> ans = new ArrayList<>();
            ans.add(this.arr[max] > query ? -1 : this.arr[max]);
            ans.add(this.arr[min] < query ? -1 : this.arr[min]);
            res.add(ans);
        }
        return res;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    private int searchMax(int[] arr, int left, int right, int target) {
        while (left < right) {
            int mid = left + 1 + ((right - left) >> 1);
            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private int searchMin(int[] arr, int left, int right, int target) {
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

}
