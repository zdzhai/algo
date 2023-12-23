package com.yugutou.charpter19_dp.level2;

public class NumDecodings {
    public static void main(String[] args) {
        String ss = "12";
        System.out.println(numDecodings(ss));
    }

    /**
     * 考虑最后一步
     * dp[i]表示长度为i的字符串的最大解码方法个数
     * if(i)是有效的，dp[i] = dp[i - 1](s[i - 1]对应一个字母) +
     * dp[i - 2](s[i - 1][i - 2]对应一个字母)
     * if(i)是无效的 为0无效，dp[i] = dp[i - 1]
     * @param s
     * @return
     */
    public static int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if (i > 1 && check(s, i)) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    public static boolean check(String s, int i) {
        if (s.charAt(i - 2) == '0') {
            return false;
        }
        if ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') > 26) {
            return false;
        }
        return true;
    }

}
