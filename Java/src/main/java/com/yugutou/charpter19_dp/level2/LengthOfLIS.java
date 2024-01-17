package com.yugutou.charpter19_dp.level2;

import java.util.Arrays;

/**
 * leetcode 300.最长递增子序列
 * LeetCode300.
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 */
public class LengthOfLIS {
    public static void main(String[] args) {
        int[] nums = {7,7,7,7,7,7,7};
        System.out.println(lengthOfLIS(nums));
        System.out.println(lengthOfLIS2(nums));
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

    /**
     * 使用贪心+二分查找优化
     * @param nums
     * @return
     */
    public static int lengthOfLIS2(int[] nums) {
        int n = nums.length, ans = 1;
        //f[]数组存放的是长度为len的上升子序列的最小结尾元素
        int[] f = new int[n + 1];
        Arrays.fill(f, 0x3f3f3f3f);
        for (int i = 0; i < n; i++) {
            int t = nums[i];
            //为了找出小于nums[i]的最大下标，
            //在dp的解法中，是遍历O(N)，找到小于nums[i]的最大下标
            int l = 1, r = i + 1;
            while (l < r) {
                int mid = l + ((r - l) >> 1);
                if (f[mid] >= t) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            f[l] = t;
            ans = Math.max(ans, l);
        }
        return ans;
    }
}

