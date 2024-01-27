package com.yugutou.charpter9_bitree_bisearch;

/**
 * leetcode 1004.最大连续1的个数3
 * @author dongdong
 * @Date 2024/1/23 21:00
 */
public class LongestOnes {
    public static void main(String[] args) {
        int[] nums = {0,0,0,1};
        System.out.println(longestOnes(nums,4));
    }

    /**
     * 最大 可以用二分
     * 最大连续个数为 0-数组的长度
     * 时间复杂度O(logn) * O(n) = O(nlogn)
     * 空间复杂度O(n)
     * @param nums
     * @param k
     * @return
     */
    public static int longestOnes(int[] nums, int k) {
        int n = nums.length;

        //前缀和
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        int l = 0, r = n;
        while (l < r) {
            int mid = l + 1 + ((r - l) >> 1);
            if (check(nums, mid, k, sum)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    /**
     * 在k次转换下 连续1的长度能否大于等于len
     * 也就是0最多不超过k个的区间最大长度 和 len 相比
     * 如果小于len，len需要减小
     * 长度为len的区间内，是否存在0的个数小于等于k
     * 区间内0的个数 前缀和
     * O(n)
     * @param nums
     * @param len
     * @param k
     * @return
     */
    private static boolean check(int[] nums, int len, int k, int[] sum) {
        int n = nums.length;
        int l = 0, r = len - 1;
        while (r < n) {
            int tot = sum[r + 1] - sum[l];
            //区间内0的个数大于k 说明len大了 返回false
            if ((len - tot) <= k) {
                return true;
            }
            l++;
            r++;
        }
        return false;
    }

    /**
     * 定义dp[i][j]为数组长度为i( 包含i ),翻转次数为j时的最大连续1长度
     * 如果nums[i]为1， dp[i][j] = dp[i - 1][j] + 1;
     * 如果nums[i]为0，dp[i][j] = dp[i - 1][j - 1] + 1;
     * 时间复杂度O(nk) 本题会超时
     * 空间复杂度O(k)
     * @param nums
     * @param k
     * @return
     */
    public static int longestOnes2(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[2][k + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (nums[i - 1] == 1) {
                    dp[i & 1][j] = dp[(i - 1) & 1][j] + 1;
                } else {
                    dp[i & 1][j] = j == 0 ? 0 : dp[(i - 1) & 1][j - 1] + 1;
                }
                ans = Math.max(ans, dp[i & 1][j]);
            }
        }
        return ans;
    }
}
