package com.yugutou.charpter3_array.union_find;

/**
 * leetcode 200.岛屿数量
 * 两种做法：1.dfs 2.并查集
 * @author dongdong
 * @Date 2024/1/9 23:17
 */
public class NumIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(new NumIslands().numIslands(grid));
;    }

    /**
     * 使用并查集，做连通性判断，如果两个点上下/左右相连，就合并
     * @param grid
     * @return
     */
    private int row;
    private int col;
    public  int numIslands(char[][] grid) {
        row = grid.length;
        col = grid[0].length;
        UnionFind unionFind = new UnionFind(row * col);
        int space = 0;
        int[][] dir = {{1, 0},{0,1}};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '0') {
                    space++;
                }
                else if (grid[i][j] == '1') {
                    for (int k = 0; k < 2; k++) {
                        int xx = i + dir[k][0];
                        int yy = j + dir[k][1];
                        if (xx < row && yy < col && grid[xx][yy] == '1') {
                            unionFind.union(getIndex(i,j), getIndex(xx, yy));
                        }
                    }
                }
            }
        }
        for (int i = 1; i < unionFind.parent.length; i++) {
            unionFind.finalUnion(0, i);
        }
        return unionFind.getCount() - space;
    }

    public int getIndex(int i, int j) {
        return i * col + j;
    }

    static class UnionFind {
        int count;
        int[] parent;

        public int getCount() {
            return count;
        }

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (x == parent[x]) return x;
            else return parent[x] = find(parent[x]);
        }

        /**
         * 未考虑路径压缩
         * @param x
         * @param y
         */
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
            count--;
        }

        public void finalUnion(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
        }
    }
}

