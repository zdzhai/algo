package com.yugutou.charpter19_dp.level2;

import java.util.Arrays;

/**
 * LeetCode322.给你一个整数数组 coins ，表示不同面额的硬币，以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] A = {1,2,5};
        System.out.println(coinChange(A, 11));
    }

    /**
     * dfs能做，但应该会超时
     *
     * 有i个物品，重量为weight[i],其价值为value[i],有一个包能容纳m物品，求最大价值
     * dp[i][j]表示0到i个物品，放入重量为j的包中的最大价值
     * 能放i的条件,if(j - weight[i - 1] >= 0)
     * 不能放i dp[i][j] = dp[i - 1][j]
     * 放i dp[i - 1][j - weight[i - 1]] + value[i]
     * 不放i dp[i][j] = dp[i - 1][j]
     * 取较大值
     *
     *
     * dp[i]表示组成金额为i的最小硬币数
     * i >= coins[j]
     * dp[i] = min(dp[i - 2], dp[i - 5], dp[i - 7]) + 1
     *
     * @param coins
     * @param M
     * @return
     */
    public static int coinChange(int[] coins, int M) {
        if (M == 0) {
            return 0;
        }
        int[] dp = new int[M + 1];
        Arrays.fill(dp, M + 1);
        dp[0] = 0;
        for (int i = 0; i <= M; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[M] > M ? -1 : dp[M];
    }
}
