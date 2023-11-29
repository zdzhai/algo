package com.yugutou.charpter7_tree_and_recurison.level3;

import com.yugutou.tools.BinaryTree;
import com.yugutou.tools.TreeNode;

import java.util.*;

/**
 * 基于迭代实现后序遍历
 */
public class PostOrderTraversal {
    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree();
        bTree.root = bTree.buildBinaryTree();
//        bTree.root = bTree.buildBinaryTree();

        System.out.println(postOrderTraversal(bTree.root));
    }

    /**
     * 反转法实现 左右中
     * 先中右左，再列表反转
     * @param root
     * @return
     */

    public static List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                ans.add(root.val);
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            root = root.left;
        }
        Collections.reverse(ans);
        return ans;
    }
}
