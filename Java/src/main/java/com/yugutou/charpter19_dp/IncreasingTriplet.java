package com.yugutou.charpter19_dp;

import java.util.Arrays;

/**
 * leetcode 334.递增的三元子序列
 * @author dongdong
 * @Date 2024/1/16 20:14
 */
public class IncreasingTriplet {
    public static void main(String[] args) {
        int[] nums = {5,1,6};
        System.out.println(increasingTriplet(nums));
        System.out.println(increasingTriplet2(nums));
    }

    /**
     * 最长递增子序列
     * @param nums
     * @return
     */
    public static boolean increasingTriplet(int[] nums) {
        int size = nums.length;
        if (size < 3) return false;
        int[] dp = new int[size];
        Arrays.fill(dp,1);
        int ans = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                ans = Math.max(ans, dp[i]);
                if ( ans >= 3) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 贪心+二分查找
     * 贪心求解LIS
     * https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247487814&idx=1&sn=e33023c2d474ff75af83eda1c4d01892&chksm=fd9cba59caeb334f1fbfa1aefd3d9b2ab6abfccfcab8cb1dbff93191ae9b787e1b4681bbbde3&token=252055586&lang=zh_CN#rd
     * @param nums
     * @return
     */
    public static boolean increasingTriplet2(int[] nums) {
        int size = nums.length;
        if (size < 3) return false;
        int[] f = new int[size + 1];
        Arrays.fill(f,0x3f3f3f3f);
        int ans = 0;
        for (int i = 0; i < size; i++) {
            int t = nums[i];
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
        return ans >= 3;
    }

    /**
     * 定长上升子序列
     * @param nums
     * @return
     */
    public static boolean increasingTriplet3(int[] nums) {
        int size = nums.length;
        if (size < 3) return false;
        long[] f = new long[3];
        f[1] = f[2] = (int) 1e19;
        for (int i = 0; i < size; i++) {
            int t = nums[i];
            if (t > f[2]) return true;
            else if (t > f[1] && t < f[2]) f[2] = t;
            else if (t < f[1]) f[1] = t;
        }
        return false;
    }
}
