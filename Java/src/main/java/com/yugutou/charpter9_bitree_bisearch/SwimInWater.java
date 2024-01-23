package com.yugutou.charpter9_bitree_bisearch;

import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode 778.水位上升的泳池中游泳
 * @author dongdong
 * @Date 2024/1/22 20:02
 */
public class SwimInWater {
    public static void main(String[] args) {

    }

    /**
     * 首先根据所需的最少时间，可以判断出能够使用二分来筛选
     * check函数就是判断在该时间下能否游到(n-1,n-1)
     * 能否游到(n-1,n-1)也就是判断(0,0)到(n-1,n-1)是否是联通的
     * 总时间复杂度为O(n2logn)
     * @param grid
     * @return
     * O(logn)
     */
    public static int swimInWater(int[][] grid) {
        int n = grid.length;
        int l = 0, r = n * n - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            //小于t一定是不行的，mid要增大
            if (check(grid, mid)) {
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
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Deque<int[]> deque = new LinkedList<>();
        deque.addLast(new int[]{0, 0});

        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int x = cur[0], y = cur[1];
            if (x == n - 1 && y == n - 1) return true;

            for (int[] d : dir) {
                int xx = x + d[0];
                int yy = y + d[1];
                //判断是否超范围
                if (xx >= 0 && xx < n && yy >= 0 && yy < n && !visited[xx][yy]) {
                    //判断是否能游 水位必须同时淹没这两个平台
                    if (time >= Math.max(grid[x][y], grid[xx][yy])) {
                        visited[xx][yy] = true;
                        deque.addLast(new int[]{xx, yy});
                    }
                }
            }
        }

        return false;
    }



    class UnionFind{
        int[] parent;

        public UnionFind(int[] parent) {
            this.parent = parent;
        }

        int find(int x) {
            if (x != parent[x]) {
                return parent[x] = find(parent[x]);
            }
            return x;
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return;

        }

        boolean query(int x, int y) {
            return find(x) == find(y);
        }
    }
}
