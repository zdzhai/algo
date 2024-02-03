package com.yugutou.charpter19_dp;

/**
 * leetcode 72.编辑距离
 * @author dongdong
 * @Date 2024/2/2 23:01
 */
public class MinDistance {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        MinDistance minDistance = new MinDistance();
        System.out.println(minDistance.minDistance(word1, word2));
    }

    /**
     * 定义dp[i][j] 为考虑w1长度为i,w2长度为j时，将w1转换成w2的最小操作数
     * 如果w1[i]==w2[j] dp[i][j] = dp[i - 1][j - 1];
     * 如果w1[i]!=w2[j] dp[i - 1][j - 1] 表示替换 dp[i - 1][j]表示删除
     * dp[i][j - 1]表示插入 三个取最小加1
     * 这种两字符串变化的，一般都可以考虑dp，转移状态就是题中给的不同操作
     * 时间复杂度O(n*m)
     * 空间复杂度O(n*m)
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        word1 = " " + word1;
        word2 = " " + word2;
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        int[][] dp = new int[n + 1][ m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (w1[i] == w2[j]) dp[i][j] = dp[i - 1][j - 1];
                else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1],
                            Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[n][m];
    }
}
