package com.yugutou.charpter9_bitree_bisearch;

import java.util.Arrays;
import java.util.Comparator;

/**
 * leetcode 1751.最多可以参加的会议数目2
 *
 * @author dongdong
 * @Date 2024/1/31 20:11
 */
public class MaxValue {
    public static void main(String[] args) {

    }

    /**
     * 有最多能参加的会议数限制k
     * 对k二分
     * 判断能否满足可以参加k个会议，能的话最大值是多少
     * 不能的话，mid要减小
     * 如何判断能否参加mid个会议，最大不重叠区间的个数
     * 有一个容量为mid的背包，两个物品不能重叠，每个物品有其价值，求背包能装的最大价值
     *
     * @param events
     * @param k
     * @return
     */
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int[][] dp = new int[n + 1][k + 1];


        for (int i = 1; i <= n; i++) {
            int[] t = events[i - 1];
            int last = 0;
            for (int l = i - 1; l >= 1; l--) {
                if (events[l - 1][1] < t[0]) {
                    last = l;
                    break;
                }
            }
            for (int j = 1; j <= k; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[last][j - 1] + t[2]);
            }
        }
        return dp[n][k];
    }

    /**
     * 判断能否参加最多mid个会议，不能返回false
     * 能的话，求出最多参加mid个会议的最大价值
     * 有一个容量为mid的背包，每个物品的重量都是1，
     * 两个物品不能重叠，每个物品有其价值，求背包能装的最大价值
     * 不放物品i
     * dp[i][j] = dp[i - 1][j]
     * 放物品i,能放的前提是events[i][0] > events[last][1] 比events[i][0]小的最大的endDate
     * dp[i][j] = dp[last][j - 1] + events[i][2]
     *
     * @param events
     * @param k
     * @return
     */
    public int maxValue2(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events, (a, b) -> a[1] - b[1]);

        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            int[] t = events[i - 1];
            int s = t[0], e = t[1], v = t[2];
            //找到小于s的最大值end下标
            int last = 0;
            if (i >= 2) {
                int l = 1, r = i - 1;
                while (l < r) {
                    int mid = l + 1 + ((r - l) >> 1);
                    if (events[mid - 1][1] >= s) {
                        r = mid - 1;
                    } else {
                        l = mid;
                    }
                }
                last = events[r - 1][1] >= s ? 0 : r;
            }

            for (int j = 1; j <= k; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[last][j - 1] + v);
            }
        }
        return dp[n][k];
    }
}
