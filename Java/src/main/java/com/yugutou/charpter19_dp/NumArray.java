package com.yugutou.charpter19_dp;

/**
 * leetcode 303.区域和检索-数组不可变 (前缀和)
 * @author dongdong
 */
class NumArray {

    int[] sum;

    public NumArray(int[] nums) {
        int n = nums.length;
        sum = new int[n + 1];
        sum[0] = 0;
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    /**
     * 使用前缀和
     * @param left
     * @param right
     * @return
     */
    public int sumRange(int left, int right) {
        return sum[right + 1] - sum[left];
    }
}