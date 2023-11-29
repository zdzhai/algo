package com.yugutou.charpter6_tree_level_travel.level2;

import com.yugutou.tools.BinaryTree;
import com.yugutou.tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dongdong
 * @Date 2023/11/28 19:35
 */
public class LastLeft {
    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree();
        bTree.root = bTree.buildBinaryTree();
        int level = findBottomLeftValue(bTree.root);
        System.out.println(level);
    }

    /**
     * 和上边类似
     * 倒序找最后一行行的最后一个元素
     * @param root
     * @return
     */
    public static int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node = new TreeNode(-1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                node = queue.remove();
                size--;
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
            }
        }
        return node.val;
    }
}
