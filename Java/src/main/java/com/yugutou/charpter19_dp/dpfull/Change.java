package com.yugutou.charpter19_dp.dpfull;

/**
 * leetcode 518.零钱兑换2
 * @author dongdong
 * @Date 2024/1/29 20:38
 */
public class Change {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 5;
        Change change = new Change();
        System.out.println(change.change(amount, coins));
        System.out.println(change.change2(amount, coins));
    }

    /**
     * dp[i][j]表示前i个硬币中，凑成总和恰好为j的最大组合数
     * 不选第i个，dp[i][j] = dp[i - 1][j];
     * 选1个第i个，dp[i][j] = dp[i][j] + dp[i - 1][j - coins[i]];
     * 选2个第i个，dp[i][j] = dp[i][j] + dp[i - 1][j - 2 * coins[i]];
     * 选k个第i个，dp[i][j] = dp[i][j] + dp[i - 1][j - k * coins[i]];
     *
     * 时间复杂度O(n*M2)
     * 空间复杂度O(n*M)
     * @return
     */
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        dp[0][0] = 1;
        //直接从数组第1个数开始初始化
        for (int j = 1; j <= amount; j++) {
            int t = coins[0];
            int k = j / t;
            if (k * t == j) {
                dp[0][j] = 1;
            } else {
                dp[0][j] = 0;
            }
        }

        for (int i = 1; i < n; i++) {
            int t = coins[i];
            for (int j = 0; j <= amount; j++) {
                int ans1 = dp[i - 1][j];
                int k = 1;
                int ans2 = 0;
                while (k * t <= j) {
                    ans2 += dp[i - 1][j - k * t];
                    k++;
                }
                dp[i][j] = ans1 + ans2;
            }
        }
        return dp[n - 1][amount];
    }

    /**
     * 一维数组优化
     * 时间复杂度O(n*M)
     * 空间复杂度O(amount)
     * @param amount
     * @param coins
     * @return
     */
    public int change2(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        //不使用数组数时，凑成0的方式为1个，凑成其他数的方式均为0个
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            int val = coins[i - 1];
            for (int j = val; j <= amount; j++) {
                dp[j] += dp[j - val];
            }
        }
        return dp[amount];
    }

}
