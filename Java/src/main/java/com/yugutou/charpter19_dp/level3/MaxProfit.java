package com.yugutou.charpter19_dp.level3;

/**
 * @author dongdong
 * @Date 2023/12/24 21:04
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }

    /**
     * dp[i]表示在第i天卖出的最大利润
     * 考虑最后一步
     * 0-j的价格和第i天的比较
     * dp[i - 1] 和 prices[i] - min
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0]= 0;
        int ans = 0;
        for (int j = 1; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                dp[j] = Math.max(dp[j], prices[j] - prices[i]);
            }
            ans = Math.max(ans,dp[j]);
        }
        return ans;
    }

    public static int maxProfit2(int[] prices) {
        int n = prices.length;
        if (n == 1) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 0;
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
        }
        return dp[n - 1];
    }
}
