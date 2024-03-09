package com.yugutou.charpter8_tree_hot_problems;

/**
 * leetcode 2673.使二叉树所有路径值相等的最小代价
 * @author dongdong
 * @Date 2024/2/28 21:46
 */
public class MinIncrements {
    public static void main(String[] args) {
        int[] cost = {1,5,2,2,3,3,1};
        MinIncrements minIncrements = new MinIncrements();
        System.out.println(minIncrements.minIncrements(cost.length - 1, cost));
    }

    /**
     * 先得到所有根节点到叶子节点的和
     * @param n
     * @param cost
     * @return
     */
    int ans = 0;
    public int minIncrements(int n, int[] cost) {
        dfs(1, n, cost);
        return ans;
    }

    /**
     * 返回以i为根节点的，到达所有叶子节点的路径值的最大值
     * 时间复杂度O(n)
     * 时间复杂度O(1)
     * @param i
     * @param n
     * @param cost
     * @return
     */
    private int dfs(int i, int n, int[] cost) {
        if (2 * i > n) return cost[i - 1];
        int left = dfs(2 * i, n, cost);
        int right = dfs(2 * i + 1, n, cost);
        ans += Math.abs(left - right);
        return cost[i - 1] + Math.max(left, right);
    }

}
