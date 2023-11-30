package com.yugutou.charpter8_tree_hot_problems.level1.topic_双指针;

import com.yugutou.tools.BinaryTree;
import com.yugutou.tools.TreeNode;

/**
 * LeetCode100 判断两棵树是否相同
 */
public class Common {
    public static void main(String[] args) {
        BinaryTree bTree1 = new BinaryTree();
        bTree1.root = bTree1.buildBinaryTree();

        BinaryTree bTree2 = new BinaryTree();
        bTree1.root = bTree2.buildBinaryTree();

        boolean result = isSameTree(bTree1.root, bTree2.root);

        System.out.println(result);
    }

    /**
     * 定义两个遍历树元素的节点，然后同时遍历
     * 遇到不一致就false
     * @param p
     * @param q
     * @return
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }
        boolean sameLeft = isSameTree(p.left, q.left);
        boolean sameRight = isSameTree(p.right, q.right);
        return sameLeft && sameRight;

    }
}
