package com.yugutou.charpter19_dp.level1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 路径问题
 * 第四炮：LeetCode120.三角形最小路径和
 */
public class MinimumTotal {
    public static void main(String[] args) {

        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(2, 0, 0, 0));
        list.add(Arrays.asList(3, 4, 0, 0));
        list.add(Arrays.asList(6, 5, 7, 0));
        list.add(Arrays.asList(4, 1, 8, 3));

        System.out.println(minimumTotal(list));
        System.out.println(minimumTotal2(list));
    }


    /**
     * dp[][] 表示走到i,j位置的最小路径值
     * @param tri
     * @return
     */
    public static int minimumTotal(List<List<Integer>> tri) {
        int n = tri.size();
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];
        dp[0][0] = tri.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j > 0 && j < i ) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + tri.get(i).get(j);
                } else if (j == 0 ) {
                    dp[i][0] = dp[i - 1][0] + tri.get(i).get(0);
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + tri.get(i).get(j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[n - 1][i]);
        }
        return ans;
    }

    /**
     * 使用动态数组压缩空间
     * @param tri
     * @return
     */
    public static int minimumTotal2(List<List<Integer>> tri) {
        int n = tri.size();
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[2][n];
        dp[0][0] = tri.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                dp[i & 1][j] = Integer.MAX_VALUE;
                int val = tri.get(i).get(j);
                if (j != 0) {
                    dp[i & 1][j] = Math.min(dp[i & 1][j], dp[(i - 1) & 1][j - 1] + val);
                }
                if (j != i) {
                    dp[i & 1][j] = Math.min(dp[i & 1][j], dp[(i - 1) & 1][j] + val);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[(n - 1) & 1][i]);
        }
        return ans;
    }

}
