package com.yugutou.charpter19_dp.level2;

import java.util.Arrays;

/**
 * LeetCode279.给你一个整数n ，返回和为n的完全平方数的最少数量。
 */
public class NumSquares {
    public static void main(String[] args) {
        System.out.println(numSquares(2));
    }

    /**
     * dp[i]表示i的最少完全平方数量
     * 考虑最后一步 i
     * j < i if i - j*j >= 0 dp[i] = min(dp[i], dp[i - j * j] + 1)
     * i - j*j >= 0
     * @param n
     * @return
     */
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[1] = 1;
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
