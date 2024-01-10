package com.yugutou.charpter18_backtracking;

/**
 * leetcode 200.岛屿数量
 * 两种做法：1.dfs 2.并查集
 * @author dongdong
 * @Date 2024/1/9 23:17
 */
public class NumIslands {
    public static void main(String[] args) {

    }

    /**
     * 使用dfs来做
     * dfs上下左右四个方向能够把1块连续区域全部置0
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {
        int row = grid.length, col = grid[0].length;
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void dfs(char[][] grid, int x, int y) {
        //下 右 左 上
        int[][] direction = {{0,1}, {1,0}, {-1,0},{0,-1}};

        for (int i = 0; i < 4; i++) {
            int xx = x + direction[i][0];
            int yy = y + direction[i][1];
            if (xx < 0 || xx >= grid.length
                    || yy < 0 || yy >= grid[0].length || grid[xx][yy] == '0') {
                continue;
            }
            grid[xx][yy] = '0';
            dfs(grid, xx, yy);
        }
    }


}