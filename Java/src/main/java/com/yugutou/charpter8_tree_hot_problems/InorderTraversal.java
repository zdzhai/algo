package com.yugutou.charpter8_tree_hot_problems;

import com.yugutou.tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dongdong
 * @Date 2024/2/10 23:33
 */
public class InorderTraversal {
    public static void main(String[] args) {

    }
    List<Integer> ans = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        if (root.left != null) inorderTraversal(root.left);
        ans.add(root.val);
        if (root.right != null) inorderTraversal(root.right);
        return ans;
    }
}
