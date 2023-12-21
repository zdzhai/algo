package com.yugutou.charpter19_dp.level1;

/**
 * 路径问题 leetcode62
 * 第二炮：基本问题：统计路径总数
 * 二维数组实现
 */
public class 第二炮UniquePaths {
    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println(uniquePaths(m, n));
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = 1;
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
