package com.yugutou.charpter19_dp;

/**
 * leetcode 712.两个字符串的最小ASCII删除和
 * @author dongdong
 * @Date 2024/2/12 23:26
 */
public class MinimumDeleteSum {
    public static void main(String[] args) {
        String s1 = "sea";
        String s2 = "eat";
        MinimumDeleteSum minimumDeleteSum = new MinimumDeleteSum();
        System.out.println(minimumDeleteSum.minimumDeleteSum(s1, s2));
    }

    /**
     * dp[i][j]表示s1前i个字符，s2前j个字符时，使s1和s2相同时要删除字符ascii的最小值
     *
     *
     * @param s1
     * @param s2
     * @return
     */
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        s1 = " " + s1;
        s2 = " " + s2;
        int[][] dp = new int[n + 1][m + 1];
        char[] s = s1.toCharArray();
        char[] p = s2.toCharArray();

        dp[0][0] = s[0];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + s[i];
        }
        for (int j = 1; j <= m; j++) {
            dp[0][j] = dp[0][j - 1] + p[j];
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s[i] == p[j]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + s[i], dp[i][j - 1] + p[j]);
                }
            }
        }
        return dp[n][m] - s[0];
    }
}
