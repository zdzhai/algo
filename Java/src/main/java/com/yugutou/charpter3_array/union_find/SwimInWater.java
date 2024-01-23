package com.yugutou.charpter3_array.union_find;

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
     * todo 并查集解法
     * 总时间复杂度为O(n2logn)
     * @param grid
     * @return
     * O(logn)
     */
    public static int swimInWater(int[][] grid) {
        int n = grid.length;
        int l = 0, r = n * n - 1;
        return r;
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
