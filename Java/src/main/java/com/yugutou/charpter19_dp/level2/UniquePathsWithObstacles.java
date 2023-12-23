package com.yugutou.charpter19_dp.level2;

/**
 * 路径中存在障碍物
 */
public class UniquePathsWithObstacles {
    public static void main(String[] args) {
        int[][] array = new int[3][3];
        array[0] = new int[]{0, 0, 0};
        array[1] = new int[]{0, 1, 0};
        array[2] = new int[]{0, 0, 0};
        System.out.println(uniquePathsWithObstacles(array));
    }

    /**
     * 使用动态规划解决
     * dp[i][j]表示在i,j处的最大路径
     * 考虑最后一步
     * if(obstacleGrid[i][j] != 1)
     * dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
     * @param obstacleGrid
     * @return
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    if (i > 0 && j > 0) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    } else if (j > 0) {
                        dp[0][j] = dp[0][j - 1];
                    } else if (i > 0) {
                        dp[i][0] = dp[i - 1][0];
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
