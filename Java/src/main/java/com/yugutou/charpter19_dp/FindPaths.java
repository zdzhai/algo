package com.yugutou.charpter19_dp;

import java.util.Arrays;

/**
 * leetcode 576.出界的路径数
 *
 * @author dongdong
 * @Date 2024/1/25 20:37
 */
public class FindPaths {
    public static void main(String[] args) {
        FindPaths findPaths = new FindPaths();
        System.out.println(findPaths.findPaths(1, 3, 3, 0, 1));
        System.out.println(findPaths.findPaths2(1, 3, 3, 0, 1));
    }

    /**
     * 上下左右四个方向有限次数的移动，使得移出边界的总次数
     * 从(m,n)位置移动maxMove次移出边界的次数
     * 开始起点,maxMove是变化的， m,n是不变的
     *
     * @param m
     * @param n
     * @param maxMove
     * @param startRow
     * @param startColumn
     * @return
     */
    int mod = 1000000007;
    //记忆化数组 将m,n转换为一维的。
    int[][] cache;
    //上下左右
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int findPaths(int m, int n,
                         int maxMove, int startRow, int startColumn) {
        cache = new int[m * n][maxMove + 1];

        for (int i = 0; i < m * n; i++) {
            Arrays.fill(cache[i], -1);
        }
        return dfs(m, n, maxMove, startRow, startColumn);
    }


    /**
     * 将记忆化搜索改为动态规划
     * 从(m,n)位置移动maxMove次移出边界的次数
     * dp[i][j] = dp[i][j] + dp[k][maxMove - 1]  k为四个方向
     *
     * @param m
     * @param n
     * @param maxMove
     * @param startRow
     * @param startColumn
     * @return
     */
    public int findPaths2(int m, int n,
                          int maxMove, int startRow, int startColumn) {
        int[][] dp = new int[m * n][maxMove + 1];

        // 初始化边缘格子的路径数量
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) add(i, j, n, dp, maxMove);
                if (i == m - 1) add(i, j, n, dp, maxMove);
                if (j == 0) add(i, j, n, dp, maxMove);
                if (j == n - 1) add(i, j, n, dp, maxMove);
            }
        }

        for (int step = 1; step <= maxMove; step++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int idx = getIndex(i, j, n);
                    for (int k = 0; k < 4; k++) {
                        int row = i + dir[k][0];
                        int col = j + dir[k][1];
                        if (row >= 0 && row < m && col >= 0 && col < n) {
                            int loc = getIndex(row, col, n);
                            dp[idx][step] += dp[loc][step - 1];
                            dp[idx][step] &= mod;
                        }
                    }
                }
            }
        }

        return dp[getIndex(startRow, startColumn, n)][maxMove];
    }

    // 为每个「边缘」格子，添加一条路径
    public void add(int x, int y, int n, int[][] dp, int maxMove) {
        int idx = getIndex(x, y, n);
        for (int step = 1; step <= maxMove; step++) {
            dp[idx][step]++;
        }
    }


    /**
     * 递归结束：m,n出界了 + 1  m,n没出界，但是maxMove==0 返回0
     *
     * @param m
     * @param n
     * @param maxMove
     * @param startRow
     * @param startColumn
     * @return
     */
    private int dfs(int m, int n, int maxMove, int startRow, int startColumn) {

        if (startRow < 0 || startRow >= m || startColumn < 0 || startColumn >= n) {
            return 1;
        }
        if (startRow >= 0 && startRow < m && startColumn >= 0 && startColumn < n && maxMove == 0) {
            return 0;
        }

        if (cache[getIndex(startRow, startColumn, n)][maxMove] != -1) {
            return cache[getIndex(startRow, startColumn, n)][maxMove];
        }
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            int row = startRow + dir[i][0];
            int col = startColumn + dir[i][1];
            sum += dfs(m, n, maxMove - 1, row, col);
            sum %= mod;
        }
        cache[getIndex(startRow, startColumn, n)][maxMove] = sum;
        return sum;
    }

    public int getIndex(int m, int n, int col) {
        return m * col + n;
    }
}
