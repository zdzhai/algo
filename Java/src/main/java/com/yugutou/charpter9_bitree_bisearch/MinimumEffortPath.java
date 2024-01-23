package com.yugutou.charpter9_bitree_bisearch;

import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode 1631.最小体力消耗路径
 * @author dongdong
 * @Date 2024/1/22 21:19
 */
public class MinimumEffortPath {
    public static void main(String[] args) {
        int[][] heights = {{1,10,6,7,9,10,4,9}};
        System.out.println(minimumEffortPath(heights));
    }

    public static int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int l = 0, r = 20;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            //小于t一定是不行的，mid要增大
            if (check(heights, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    /**
     * 判断在该time下，判断(0,0)到(n-1,n-1)是否是联通的
     * 是true,否false
     * @param grid
     * @param mid
     * @return
     * O(n2)
     */
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0 , 1}};
    private static boolean check(int[][] grid, int time) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Deque<int[]> deque = new LinkedList<>();
        deque.addLast(new int[]{0, 0});

        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int x = cur[0], y = cur[1];
            if (x == m - 1 && y == n - 1) return true;

            for (int[] d : dir) {
                int xx = x + d[0];
                int yy = y + d[1];
                //判断是否超范围
                if (xx >= 0 && xx < m && yy >= 0 && yy < n && !visited[xx][yy]) {
                    //判断是否能游 水位必须同时淹没这两个平台
                    if (time >= Math.abs(grid[x][y] - grid[xx][yy])) {
                        visited[xx][yy] = true;
                        deque.addLast(new int[]{xx, yy});
                    }
                }
            }
        }

        return false;
    }
}
