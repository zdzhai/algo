package com.yugutou.charpter3_array.union_find;

/**
 * leetcode 990. 等式方程的可满足性
 * @author dongdong
 * @Date 2024/1/4 22:59
 */
public class EquationsPossible {
    public static void main(String[] args) {
        EquationsPossible equationsPossible = new EquationsPossible();
        String[] equations = {"a==b","b==c","a==c"};
        System.out.println( equationsPossible.equationsPossible(equations));
    }

    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind(26);

        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                unionFind.union(equation.charAt(0) - 'a', equation.charAt(3) - 'a');
            }
        }

        for (String equation : equations) {
            if (equation.charAt(1) == '!' &&
                    unionFind.find(equation.charAt(0) - 'a')
                            .equals(unionFind.find(equation.charAt(3) - 'a'))) {
                return false;
            }
        }
        return true;
    }

    class UnionFind {

        int[] parent = new int[26];
        int[] ranks = new int[26];

        public UnionFind(int num) {
            for (int i = 0; i < num; i++) {
                parent[i] = i;
                ranks[i] = 0;
            }
        }

        public Integer find(int x) {
            while (x != parent[x]) {
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            int rankX = ranks[rootX];
            int rankY = ranks[rootY];
            //小的往大的合并
            if (rankX < rankY) {
                parent[rootX] = rootY;
            } else if (rankX > rankY) {
                parent[rootY] = rootX;
            } else {
                parent[rootX] = rootY;
                ranks[rootY]++;
            }
        }

        /*public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
        }*/
    }
}


