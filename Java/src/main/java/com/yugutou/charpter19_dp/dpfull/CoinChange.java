package com.yugutou.charpter19_dp.dpfull;

/**
 * leetcode 322.零钱兑换
 *
 * @author dongdong
 * @Date 2024/1/29 19:20
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {2,5,10,1};
        int M = 27;
        System.out.println(coinChange(coins, M));
        System.out.println(coinChange2(coins, M));
        System.out.println(coinChange3(coins, M));
    }

    /**
     * 完全背包问题
     * dp[i][j]表示前i个物品中，能恰好装满容量为j的背包的物品个数
     * 不选第i个物品 dp[i][j] = dp[i - 1][j];
     * 选1个第i个物品，dp[i][j] = dp[i - 1][j - weight[i] + 1;
     * 选2个第i个物品，dp[i][j] = dp[i - 1][j - 2 * weight[i] + 2;
     * 选k个第i个物品，dp[i][j] = dp[i - 1][j - k * weight[i] + k;
     * 时间复杂度
     * O(n*M2)
     * @param coins
     * @param M
     * @return
     */
    public static int coinChange(int[] coins, int M) {
        int n = coins.length;
        int[][] dp = new int[n + 1][M + 1];
        int INF = 0x3f3f3f3f;

        for (int j = 1; j <= M; j++) {
            dp[0][j] = INF;
        }

        for (int i = 1; i <= n; i++) {
            int val = coins[i - 1];
            for (int j = 0; j <= M; j++) {
                int ans1 = dp[i - 1][j];
                int k = 1;
                int ans2 = INF;
                while (k * val <= j) {
                    if (dp[i - 1][j - k * val] != INF) {
                        ans2 = Math.min(ans2, dp[i - 1][j - k * val] + k);
                    }
                    k++;
                }
                dp[i][j] = Math.min(ans1, ans2);
            }
        }
        return dp[n][M] == INF ? - 1 : dp[n][M];
    }

    /**
     * 背包空间优化
     * O(n*M2)
     * @param coins
     * @param M
     * @return
     */
    public static int coinChange2(int[] coins, int M) {
        int n = coins.length;
        int INF = 0x3f3f3f3f;
        int[][] dp = new int[2][M + 1];
        for (int j = 0; j <= M; j++) {
            int t = coins[0];
            int k = j / t;
            if (k * t == j) {
                dp[0][j] = k;
            } else {
                dp[0][j] = INF;
            }
        }

        for (int i = 1; i < n; i++) {
            int t = coins[i];
            for (int j = 0; j <= M; j++) {
                int ans1 = dp[(i - 1) & 1][j];
                int k = 1;
                int ans2 = INF;
                while (k * t <= j) {
                    if (dp[(i - 1) & 1][j - k * t] != INF) {
                        ans2 = Math.min(ans2, dp[(i - 1) & 1][j - k * t] + k);
                    }
                    k++;
                }
                dp[i & 1][j] = Math.min(ans1, ans2);
            }
        }
        return dp[(n - 1) & 1][M] == INF ? -1 : dp[(n - 1) & 1][M];
    }

    /**
     * 一维数组优化
     * 时间复杂度O(n*M)
     * @param coins
     * @param M
     * @return
     */
    public static int coinChange3(int[] coins, int M) {
        int n = coins.length;
        int[] dp = new int[M + 1];
        int INF = 0x3f3f3f3f;

        for (int j = 1; j <= M; j++) {
            dp[j] = INF;
        }

        for (int i = 1; i <= n; i++) {
            int val = coins[i - 1];
            for (int j = val; j <= M; j++) {
                int ans = INF;
                if (dp[j - val] != INF) {
                    ans = Math.min(ans, dp[j - val] + 1);
                }
                dp[j] = Math.min(dp[j], ans);
            }
        }
        return dp[M] == INF ? -1 : dp[M];
    }
}
