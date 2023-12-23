package com.yugutou.charpter19_dp.level3;

/**
 * @author dongdong
 * @Date 2023/12/23 18:33
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "aaaa";
        System.out.println(longestPalindrome3(s));
    }

    /**
     * 暴力 两重循环
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        return s;
    }

    /**
     * dfs 不能不连续
     *
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        return s;
    }

    /**
     * 动态规划
     * dp[i][j]表示i-j是否是回文字串
     * 考虑最后一步
     * dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true
     *
     * @param s
     * @return
     */
    public static String longestPalindrome3(String s) {
        int n = s.length();
        if (n == 1) {
            return s;
        }
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int left = 0, right = 0, maxLength = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if ( s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j - i > maxLength) {
                        left = i;
                        right = j;
                        maxLength = right - left;
                    }
                }
            }
        }
        return s.substring(left, right + 1);
    }
}
