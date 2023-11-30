package com.yugutou.charpter8_tree_hot_problems.level2;



import com.yugutou.tools.NTree;
import com.yugutou.tools.NTreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/**
 * N叉树的最大深度问题
 *
 * @return
 */
public class MaxDepth_N {
    public static void main(String[] args) {
        NTree nTree = new NTree();
        nTree.root = nTree.buildNTree();
        int result = maxDepth_N(nTree.root);
        System.out.println(result);

    }

    /**
     * root == null return 0
     *
     * @param root
     * @return
     */
    public static int maxDepth_N(NTreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.children == null || root.children.isEmpty()) {
            return 1;
        }
        int maxDepth = 0;
        for (NTreeNode child : root.children) {
            maxDepth = Math.max(maxDepth, maxDepth_N(child));
        }
        return maxDepth + 1;
    }
}
