package com.yugutou.charpter8_tree_hot_problems.level2;
import com.yugutou.tools.BinaryTree;
import com.yugutou.tools.TreeNode;

/**
 * LeetCode110 判断平衡二叉树
 */
public class IsBalance {
    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree();
        bTree.root = bTree.buildBinaryTree();
        boolean result = false;
        int testMethod = 1;
        switch (testMethod) {
            case 1://方法1 自下而上
                result = isBalanced_1(bTree.root);
                break;
            case 2://2.自上而下
                result = isBalanced_2(bTree.root);
        }
        System.out.println(result);

    }

    /**
     * 方法1 自下而上
     *
     * @param root
     * @return
     */
    public static boolean isBalanced_1(TreeNode root) {
        return recur(root) != -1;
    }

    public static int recur(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = recur(root.left);
        int rightHeight = recur(root.right);
        return Math.abs(leftHeight - rightHeight) < 2 ? Math.max(leftHeight, rightHeight) + 1 : -1;
    }

    /**
     * 2.自上而下
     *
     * @param root
     * @return
     */
    public static boolean isBalanced_2(TreeNode root) {
        if (root == null) return true;
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced_2(root.left) && isBalanced_2(root.right);
    }

    private static int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

}
