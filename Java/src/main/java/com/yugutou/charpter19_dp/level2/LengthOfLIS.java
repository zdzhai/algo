package com.yugutou.charpter19_dp.level2;

import java.util.Arrays;

/**
 * LeetCode300.
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 */
public class LengthOfLIS {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,2,3};
        System.out.println(lengthOfLIS(nums));
    }

    /**
     * 1 1 1 2 2 3 4 4
     * dp[j]表示0-j的最长递增子序列长度
     * 考虑最后一步，j之前的每个数i都要比一遍，
     * if nums[i] < nums[j]      dp[j] = max(dp[j], dp[i] + 1);
     *
     * if i < j && nums[i] < nums[j]
     *  dp[j] = max(dp[j], dp[i] + 1)
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}

