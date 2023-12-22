package com.yugutou.charpter19_dp.level2;

import java.util.Arrays;

/**
 * LeetCode674.给定一个未经排序的整数数组，
 * 找到最长且连续递增的子序列，并返回该序列的长度。
 */
public class FindLengthOfLCIS {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};
        System.out.println(findLengthOfLCIS(nums));
        System.out.println(findLengthOfLCIS2(nums));
    }

    /**
     * dp[i]表示局部的最长连续递增子序列的长度
     * if (nums[i] > nums[i - 1]) dp[i] = dp[i - 1] + 1
     * @param nums
     * @return
     */
    public static int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    /**
     * 使用滑动窗口
     * @param nums
     * @return
     */
    public static int findLengthOfLCIS2(int[] nums) {
        int left = 0, right = 1, n = nums.length;
        int ans = 1;
        while (right < n) {
            while (right < n && nums[right] > nums[right - 1]) {
                right++;
            }
            ans = Math.max(ans, right - left);
            left = right;
            right++;
        }
        return ans;
    }
}
