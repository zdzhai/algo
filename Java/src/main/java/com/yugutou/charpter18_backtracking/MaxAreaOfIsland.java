package com.yugutou.charpter18_backtracking;

import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode 695.岛屿的最大面积
 *
 * @author dongdong
 * @Date 2024/2/1 11:05
 */
public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
        //System.out.println(maxAreaOfIsland.maxAreaOfIsland(grid));
        //System.out.println(maxAreaOfIsland.maxAreaOfIsland2(grid));
        System.out.println(maxAreaOfIsland.maxAreaOfIsland3(grid));
    }

    /**
     * @param grid
     * @return
     */
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m, n;
    int temp;
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    temp = 1;
                    dfs(i, j, grid);
                    ans = Math.max(ans, temp);
                }
            }
        }
        return ans;
    }

    /**
     * 深度优先遍历
     * 时间复杂度O(m*n)
     * @param x
     * @param y
     * @param grid
     */
    private void dfs(int x, int y, int[][] grid) {
        if (grid[x][y] == 0) return;
        grid[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int xx = x + dir[i][0];
            int yy = y + dir[i][1];
            if (xx < 0 || xx >= m || yy < 0 || yy >= n) continue;
            if (grid[xx][yy] == 1) {
                temp++;
                dfs(xx, yy, grid);
            }
        }
    }

    /**
     * 广度优先遍历
     * 时间复杂度O(m*n)
     * 空间复杂度O(m*n)
     * @param grid
     * @return
     */
    public int maxAreaOfIsland2(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    temp = 0;
                    Deque<int[]> deque = new LinkedList<>();
                    deque.addLast(new int[]{i,j});
                    while (!deque.isEmpty()) {
                        int size = deque.size();
                        temp += size;
                        for (int l = 0;l < size; l++) {
                            int[] peek = deque.removeFirst();
                            int a = peek[0], b = peek[1];
                            grid[a][b] = 0;
                            for (int k = 0; k < 4; k++) {
                                int xx = a + dir[k][0];
                                int yy = b + dir[k][1];
                                if (xx < 0 || xx >= m || yy < 0 || yy >= n) continue;
                                if (grid[xx][yy] == 1) {
                                    grid[xx][yy] = 0;
                                    deque.add(new int[]{xx, yy});
                                }
                            }
                        }
                    }
                }
                ans = Math.max(ans, temp);
            }
        }
        return ans;
    }

    /**
     * 使用并查集
     * 时间复杂度O(m*n)
     * 空间复杂度O(m*n)
     * @param grid
     * @return
     */
    int col;
    int max;
    public int maxAreaOfIsland3(int[][] grid) {
        col = grid[0].length;
        int m = grid.length, n = grid[0].length;
        UnionFind unionFind = new UnionFind(grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    //下 右
                    if (i + 1 < m && grid[i + 1][j] == 1)
                        unionFind.union(getIdx(i, j), getIdx(i + 1, j));
                    if (j + 1 < n && grid[i][j + 1] == 1)
                        unionFind.union(getIdx(i, j), getIdx(i, j + 1));
                }
            }
        }
        return max;
    }

    class UnionFind {
        int[] parent;
        int[] size;
        public UnionFind(int[][] grid){
            int m = grid.length, n = grid[0].length;
            this.parent = new int[m * n];
            this.size = new int[m * n];
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(grid[i][j] == 1){ // 针对单格岛，赋值parents[k]和size[k]
                        int k = i * n + j;
                        parent[k] = k;
                        size[k] = 1;
                        if(max != 1) max = 1; // 有单格岛时更新max=1
                    }
                }
            }
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
            int sizeX = size[rootX];
            int sizeY = size[rootY];
            //x挂到y上
            if (sizeX < sizeY) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
                max = Math.max(max, size[rootY]);
            } else {
                //y挂到x上
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
                max = Math.max(max, size[rootX]);
            }
        }
    }

    public int getIdx(int x, int y) {
        return x * col + y;
    }
}
