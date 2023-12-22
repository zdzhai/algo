package com.yugutou.charpter19_dp.level2;

public class CanJump {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }

    /**
     * dp[i]表示到达i后的剩余最大距离
     * if(dp[i - 1]) > 0
     * dp[i] = max(dp[i - 1] - 1 , nums[i]);
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        int n =nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = Math.max( dp[i - 1] - 1, nums[i]);
            } else {
                return false;
            }
        }
        return dp[n - 1] >= 0;
    }
}
