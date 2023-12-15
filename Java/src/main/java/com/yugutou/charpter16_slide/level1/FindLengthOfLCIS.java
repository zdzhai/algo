package com.yugutou.charpter16_slide.level1;

import java.util.Arrays;

public class FindLengthOfLCIS {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7, 8, 9, 2};
        System.out.println(findLengthOfLCIS_1(nums));
        System.out.println(findLengthOfLCIS_2(nums));
        System.out.println(findLengthOfLCIS_3(nums));
    }

    /**
     * 使用动态滑动窗口
     * @param nums
     * @return
     */
    public static int findLengthOfLCIS_1(int[] nums) {
        int left = 0, right = 1;
        int res = 1;
        while (right < nums.length) {
            if (nums[right] <= nums[right - 1]) {
                left = right;
            }
            right++;
            res = Math.max(res, right - left);
        }
        return res;
    }

    /**
     * 使用滑动窗口，出现下降序列时，重新计数
     * @param nums
     * @return
     */
    public static int findLengthOfLCIS_2(int[] nums) {
        int curLen = 1;//当前连续递增区间的长度
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i]) {
                //不满足要求，重新开始计数
                curLen = 1;
            } else {
                curLen++;
            }
            res = Math.max(curLen, res);
        }
        return res;
    }

    /**
     * 使用动态规划
     * @param nums
     * @return
     */
    public static int findLengthOfLCIS_3(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
