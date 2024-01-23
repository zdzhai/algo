package com.yugutou.charpter19_dp;

/**
 * leetcode 1143.最长公共子序列
 * @author dongdong
 * @Date 2024/1/20 20:30
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }

    /**
     * dp[i][j]表示s1长度为i，s2长度为j时的最长公共子序列
     * s1[i] == s2[j] dp[i][j] = dp[i - 1][j - 1] + 1
     * s1[i] != s2[j] dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1])
     * 初始化
     * 时间复杂度O(n*m)
     * 空间复杂度O(n*m)
     * @param text1
     * @param text2
     * @return
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        text1 = " " + text1;
        text2 = " " + text2;
        char[] ch1 = text1.toCharArray();
        char[] ch2 = text2.toCharArray();
        int n = ch1.length, m = ch2.length;
        int[][] dp = new int[n][m];
        //初始化
        for (int i = 0; i < n; i++) dp[i][0] = 1;
        for (int i = 0; i < m; i++) dp[0][i] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (ch1[i] == ch2[j]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n - 1][m - 1] - 1;
    }
}
