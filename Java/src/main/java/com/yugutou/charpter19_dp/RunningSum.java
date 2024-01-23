package com.yugutou.charpter19_dp;

/**
 * leetcode 1480.一维数组的动态和(前缀和)
 * @author dongdong
 * @Date 2024/1/21 16:57
 */
public class RunningSum {
    public static void main(String[] args) {

    }

    public static int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) sum[0] = nums[0];
            else {
                sum[i] = sum[i - 1] + nums[i];
            }
        }
        return sum;
    }
}
