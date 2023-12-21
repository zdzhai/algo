package com.yugutou.charpter19_dp.level1;

/**
 * @author dongdong
 * @Date 2023/12/20 20:55
 */
public class MinFallingPathSum {
    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        matrix[0] = new int[]{2,1,3};
        matrix[1] = new int[]{6,5,4};
        matrix[2] = new int[]{7,8,9};
        System.out.println(minFallingPathSum(matrix));
    }

    /**
     * dp[][]表示到达位置i，j的最小路径和
     * 分三种情况
     * 1. j = 0 则从i-1, j 和 i-1,j + 1中找，注意边界
     * 2. j = n-1 则从i-1, j 和 i-1,j - 1中找，注意边界
     * 3. 从i-1, j ；i-1,j - 1和 i - 1, j + 1中找
     * @param matrix
     * @return
     */
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];
                /*if (j == 0) {
                    dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][j + 1]) + val;
                } else if (j == n - 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + val;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j],
                            Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1])) + val;
                }*/
                dp[i][j] = Integer.MAX_VALUE;
                if (j != 0) {
                    dp[i][j] = Math.min(dp[i][j],
                            Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + val);
                }
                if (j != n - 1) {
                    dp[i][j] = Math.min(dp[i][j],
                            Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + val);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[n - 1][i]);
        }
        return ans;
    }
}
