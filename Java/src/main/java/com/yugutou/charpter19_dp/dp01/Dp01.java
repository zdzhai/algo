package com.yugutou.charpter19_dp.dp01;

/**
 * 01背包
 * @author dongdong
 * @Date 2024/1/26 20:37
 */
public class Dp01 {
    public static void main(String[] args) {

    }

    /**
     * 定义一个二维数组 到第i个物品,背包容量为j时的最大价值
     * @param weight
     * @param value
     * @param V
     * @return
     */
    int[][] cache;
    public int dp(int[] weight, int[] value, int V) {
        int n = weight.length;
        int[][] dp = new int[n][V + 1];

        for (int i = 0; i <= V; i++) {
            dp[0][i] = i >= weight[0] ? value[0] : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= V; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= weight[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        return dp[n - 1][V];
    }

    /**
     * 优化内存
     * @param weight
     * @param value
     * @param V
     * @return
     */
    public int dp2(int[] weight, int[] value, int V) {
        int n = weight.length;
        int[][] dp = new int[2][V + 1];

        for (int i = 0; i <= V; i++) {
            dp[0][i] = i >= weight[0] ? value[0] : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= V; j++) {
                dp[i & 1][j] = dp[(i - 1) & 1][j];
                if (j >= weight[i]) {
                    dp[i & 1][j] = Math.max(dp[i & 1][j], dp[(i - 1) & 1][j - weight[i]] + value[i]);
                }
            }
        }
        return dp[(n - 1) & 1][V];
    }

    /**
     * 可以看到第i个值只依赖于第i个值和第i- weight[i]个值 前向依赖，所以我们从后往前更新
     * @param weight
     * @param value
     * @param V
     * @return
     */
    public int dp3(int[] weight, int[] value, int V) {
        int n = weight.length;
        int[] dp = new int[V + 1];

        for (int i = 0; i <= V; i++) {
            dp[i] = i >= weight[0] ? value[0] : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = V; j >= 0; j--) {
                dp[j] = dp[j];
                if (j >= weight[i]) {
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
                }
            }
        }
        return dp[V];
    }

    /**
     * 剩余背包容量小于第i件物品的重量 返回0
     *
     * @param weight
     * @param value
     * @param i
     * @return
     */
    private int dfs(int[] weight, int[] value, int i, int C) {
        if (C < weight[i]) return 0;

        int sum = 0;
        return 0;
    }
}
