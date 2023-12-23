package com.yugutou.charpter19_dp.level3;

/**
 * @author dongdong
 * @Date 2023/12/23 20:36
 * leetcode 152
 */
public class MaxProduct {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));
        System.out.println(maxProduct2(nums));
    }

    /**
     * dp[i][j]表示i-j的乘积
     * 考虑最后一步
     * dp[i][j] =
     * 思路应该没问题，相当于暴力，但是加了存储中间计算的结果，但是内存溢出了
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        int n = nums.length;;
        if (n == 1) {
            return nums[0];
        }
        int[][] dp = new int[n][n];
        dp[0][0] = nums[0];
        int max = dp[0][0];
        for (int j = 1; j < n; j++) {
            for (int i = 0; i <= j ; i++) {
                if (i == j) {
                    dp[i][j] = nums[j];
                } else {
                    dp[i][j] = dp[i][j - 1] * nums[j];
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }


    /**
     * dp[i]表示i存在的最大乘积
     * nums[i]就是最大，nums[i]为正，dp[i] = dp[i - 1](正数) * nums[i]
     * @param nums
     * @return
     */
    public static int maxProduct2(int[] nums) {
        int n = nums.length;;
        if (n == 1) {
            return nums[0];
        }
        int[] dpMax = new int[n];
        int[] dpMin = new int[n];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int res = dpMax[0];
        for (int i = 1; i < n; i++) {
            dpMax[i] = Math.max(nums[i],
                    Math.max(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]));
            dpMin[i] = Math.min(nums[i],
                    Math.min(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]));
            res = Math.max(dpMax[i], res);
        }
        return res;
    }
}
