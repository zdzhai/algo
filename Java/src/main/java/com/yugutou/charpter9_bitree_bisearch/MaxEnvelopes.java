package com.yugutou.charpter9_bitree_bisearch;

import java.util.Arrays;
import java.util.Comparator;

/**
 * leetcode 354.俄罗斯套娃信封问题
 * @author dongdong
 * @Date 2024/1/24 19:34
 */
public class MaxEnvelopes {
    public static void main(String[] args) {
        int[][] envelopes = {
                {1,2},
                {2,3},
                {3,4},
                {4,5},
                {5,6},
                {5,5},
                {6,7},
                {7,8}
        };
        System.out.println(maxEnvelopes(envelopes));
        System.out.println(maxEnvelopes2(envelopes));
    }

    /**
     * 先将数组按照第一个数从小到大排序
     * dp[i]数组表示信封为i个时的最多套娃个数
     * if(nums[i][0] > nums[i - 1][0] && 1 > 1) dp[i] = dp[i - 1] + 1;
     * else dp[i] = dp[i - 1];
     * 时间复杂度O(n) + O(n2) dp一定会超时
     * @param envelopes
     * @return
     */
    public static int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    /**
     * 这其实是一个最长公共子序列问题
     * 在内循环的遍历中，可以使用二分做优化，快速的查找到比当前信封小的最大信封
     * 用一个数组f保存长度为len的信封数量的最小信封尺寸，这个数组是单调的，所以可以二分
     * 时间复杂度O(n) + O(n2) dp一定会超时
     * @param envelopes
     * @return
     */
    public static int maxEnvelopes2(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[][] f = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], 0x3f3f3f3f);
        }
        int ans = 1;
        for (int i = 0; i < n; i++) {
            int[] t = envelopes[i];
            int l = 1, r = i + 1;
            while (l < r) {
                int mid = l + ((r - l) >> 1);
                if (t[0] > f[mid][0]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            f[l] = t;
            ans = Math.max(ans, l);
        }
        return ans;
    }
}
