package com.yugutou.charpter19_dp;

/**
 * leetcode 583.两个字符串的删除操作
 * @author dongdong
 * @Date 2024/2/10 23:39
 */
public class MinDistance2 {
    public static void main(String[] args) {
        String word1 = "leetcode";
        String word2 = "etco";
        MinDistance2 minDistance2 = new MinDistance2();
        System.out.println(minDistance2.minDistance(word1, word2));
    }

    /**
     * dp[i][j]为第一个字符串前i个字符，第二个字符串前j个字符时，使得两个字符串相同的最小步数
     * dp[i][j] 当s[i],s[j]相同时，dp[i][j] = dp[i - 1][j - 1]
     * 当s[i],s[j]不同时，删除s串的i dp[i - 1][j];  删除p串的j dp[i][j - 1]
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        word1 = " " + word1;
        word2 = " " + word2;
        char[] s = word1.toCharArray();
        char[] p = word2.toCharArray();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s[i] == p[j]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[n][m];
    }
}
