package com.yugutou.charpter19_dp.level3;

/**
 * @author dongdong
 * @Date 2023/12/24 21:04
 */
public class MaxProfit2 {
    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit2(prices));
    }

    /**
     * 直接贪心
     * 遇到低就买入，遇到高就卖出
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int n = prices.length;
        if (n == 1) {
            return 0;
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {
            int val = prices[i] - prices[i - 1];
            if (val > 0) {
                ans += val;
            }
        }
        return ans;
    }
}
