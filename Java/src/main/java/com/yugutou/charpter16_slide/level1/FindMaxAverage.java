package com.yugutou.charpter16_slide.level1;

public class FindMaxAverage {
    public static void main(String[] args) {

        int[] num = {1, 12, -5, -6, 50, 3};
        System.out.println(findMaxAverage(num, 4));
    }

    /**
     * 使用滑动窗口，固定窗口一直向前
     * @param nums
     * @param k
     * @return
     */
    public static double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        int widowSum = 0;
        if (k > nums.length || nums.length < 1 || k < 1) {
            return 0;
        }
        for (int i = 0; i < k; i++) {
            widowSum += nums[i];
        }
        int res = widowSum;
        for (int i = k; i < len; i++) {
            widowSum += nums[i];
            widowSum -= nums[i - k];
            res = Math.max(res, widowSum);
        }
        return (double) res / k;
    }
}
