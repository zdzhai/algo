package com.yugutou.charpter19_dp.level1;


/**
 * 路径问题
 * 第四炮：LeetCode64.最小路径和
 */
public class MinPathSum {
    public static void main(String[] args) {
        int[][] array = new int[3][3];
        array[0] = new int[]{1, 3, 1};
        array[1] = new int[]{1, 5, 1};
        array[2] = new int[]{4, 2, 1};
        System.out.println(minPathSum(array));
    }

    /**
     * 基于二维数组减少重复计算
     * dp[i][j]表示到达i,j位置最小总和
     * dp[i][j] = Math.min(dp[i -1][j],dp[i][j - 1]) + grid[i][j];
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    dp[i][j] = Math.min(dp[i -1][j],dp[i][j - 1]) + grid[i][j];
                } else if (i > 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else if (j > 0){
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
