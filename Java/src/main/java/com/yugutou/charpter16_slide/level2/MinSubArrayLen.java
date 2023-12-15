package com.yugutou.charpter16_slide.level2;

public class MinSubArrayLen {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, nums));
    }

    /**
     * 最小为1
     * 如果sum小于target，right右移
     * 如果sum大于等于target,记录最小数组长度，left右移
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, n = nums.length;
        int ans = Integer.MAX_VALUE, sum = 0;
        while (right < n) {
            sum += nums[right++];
            while (sum >= target) {
                ans = Math.min(ans, right - left);
                sum -= nums[left++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
