package com.yugutou.charpter19_dp.level3;

/**
 * leetcode 5.  最长回文子串
 * @author dongdong
 * @Date 2023/12/23 18:33
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "babaac";
        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindrome3(s));
    }

    /**
     * 暴力 两重循环
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int size = s.length();
        String ans = "";
        for (int i = 0; i < size; i++) {
            //回文串为奇数个
            int l = i - 1;
            int r = i + 1;
            String sub = subString(s, l, r);
            if (sub.length() > ans.length()) ans = sub;

            //回文串为偶数个
            l = i - 1;
            r = i + 1 - 1;
            sub = subString(s, l, r);
            if (sub.length() > ans.length()) ans = sub;
        }
        return ans;
    }

    static String subString(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
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
