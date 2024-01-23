package com.yugutou.charpter19_dp;

/**
 * @author dongdong
 * @Date 2024/1/19 20:42
 */
public class MinFallingPathSum {
    public static void main(String[] args) {

    }

    /**
     * 使用dp
     * 定义dp[i][j]为到达i,j位置的最小路径
     * 不能从同一列直接到达
     * @param grid
     * @return
     */
    public static int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++)  dp[0][i] = grid[0][i];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (k != j) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][k]);
                    }
                }
                dp[i][j] += val;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[n - 1][i]);
        }
        return ans;
    }

    /**
     * 对于n*n的状态肯定是要遍历到位，这里优化不了
     * 所以能优化的地方就是每一行寻找最小值了
     * 但是如果下一行和最小值同列不行了，就需要次小值。
     * @param grid
     * @return
     */
    public static int minFallingPathSum2(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        int max = Integer.MAX_VALUE;
        int i1 = -1, i2 = -1;
        for (int i = 0; i < n; i++) {
            int val = grid[0][i];
            dp[0][i] = val;

            //找出第一行的最小和次小
            if (val < (i1 == -1 ? max : grid[0][i1])) {
                i2 = i1;
                i1 = i;
            } else if (val < (i2 == -1 ? max : grid[0][i2])) {
                i2 = i;
            }
        }

        for (int i = 1; i < n; i++) {
            int t1 = -1, t2 = -1;
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                dp[i][j] = max;
                if (j != i1) {
                    dp[i][j] = dp[i - 1][i1] + val;
                }
                else {
                    dp[i][j] = dp[i - 1][i2] + val;
                }

                if (dp[i][j] < (t1 == -1 ? max : dp[i][t1])) {
                    t2 = t1;
                    t1 = j;
                } else if (dp[i][j] < (t2 == -1 ? max : dp[i][t2])) {
                    t2 = j;
                }
            }
            i1 = t1;
            i2 = t2;
        }
        int ans = max;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[n - 1][i]);
        }
        return ans;
    }
}
