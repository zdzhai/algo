package com.yugutou.charpter19_dp.level3;

/**
 * @author dongdong
 * @Date 2023/12/25 21:31
 */
public class Rob {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }

    /**
     * dp[i]表示在第i家时的最大利润
     * 拿第i家，（i- 1）不能拿 dp[i] = dp[i - 2] + nums[i]
     * 不拿第i家，dp[i] = dp[i - 1]
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n - 1];
    }
}
