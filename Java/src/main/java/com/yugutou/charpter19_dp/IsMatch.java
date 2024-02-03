package com.yugutou.charpter19_dp;

/**
 * leetcode 10.正则表达式匹配
 * @author dongdong
 * @Date 2024/2/1 20:51
 */
public class IsMatch {
    public static void main(String[] args) {
        String s = "", p = "a*";
        IsMatch isMatch = new IsMatch();
        System.out.println(isMatch.isMatch(s, p));
        System.out.println(isMatch.isMatch2(s, p));
    }

    /**
     * dp[i][j]表示s字符串前i个，p字符串前j个是否匹配
     * if dp[i - 1][j - 1] == true
     * if s[i] == (s[j] || . ) dp[i][j] = true
     * if dp[i - 1][j - 1] == false dp[i][j] = false
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        s = " " + s;
        p = " " + p;
        boolean[][] dp = new boolean[n + 1][m + 1];
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        dp[0][0] = true;

        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                //如果下一个字符是*,则不能单独使用，跳过
                if (j + 1 <= m && pp[j + 1] == '*'){
                    if (pp[j] != '*'){
                        continue;
                    }
                }
                //pp[j]为普通字符或者’.‘
                if (i >= 1 && pp[j] != '*') {
                    dp[i][j] = dp[i - 1][j - 1]
                            && (ss[i] == pp[j] || pp[j] == '.');
                }
                else if (pp[j] == '*') {
                    //匹配0个或者多个
                    dp[i][j] = (j >= 2 && dp[i][j - 2]) ||
                            (i >= 1 && dp[i - 1][j] && (ss[i] == pp[j - 1] || pp[j - 1] == '.'));
                }
            }
        }
        return dp[n][m];
    }

    public boolean isMatch2(String s, String p) {
        int n = s.length(), m = p.length();
        s = " " + s;
        p = " " + p;
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                //如果下一个字符是'*'，则不能单独使用
                if (j + 1 <= m && pp[j + 1] == '*') {
                    if (pp[j] == '*') continue;
                }

                //pp[j]为普通字符或者'.'
                if (i >= 1 && pp[j] != '*') {
                    dp[i][j] = dp[i - 1][j - 1]
                            && (ss[i] == pp[j] || pp[j] == '.');
                } else if (pp[j] == '*') {
                    //匹配0个dp[i][j] = dp[i][j - 2]
                    //匹配1个dp[i][j] = dp[i - 1][j - 2] && (ss[i] == pp[j - 1] || pp[j - 1] == '.')
                    //匹配2个dp[i][j] = dp[i - 2][j - 2] && ((ss[i] == pp[j - 1] && ss[i - 1] == pp[j - 1]) || pp[j - 1] == '.')
                    dp[i][j] = (j >= 2 && dp[i][j - 2]) ||
                            (i >= 1 && dp[i - 1][j] && (ss[i] == pp[j - 1] || pp[j - 1] == '.'));
                }
            }
        }
        return dp[n][m];
    }
}
