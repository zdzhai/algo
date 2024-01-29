package com.yugutou.charpter19_dp.dpfull;

import java.util.*;

/**
 * leetcode 279.完全平方数
 * @author dongdong
 * @Date 2024/1/28 18:49
 */
public class NumSquares {
    public static void main(String[] args) {
        NumSquares numSquares = new NumSquares();
        int n = 12;
        System.out.println(numSquares.numSquares(n));
        System.out.println(numSquares.numSquares2(n));
        System.out.println(numSquares.numSquares3(n));
        System.out.println(numSquares.numSquares4(n));
        System.out.println(numSquares.numSquares5(n));
    }

    /**
     * dp[i]表示构成i的最小的完全平方数数量
     * dp[i] = min(dp[i], dp[i - j * j]) + 1
     * 时间复杂度O(n的1.5次方)
     * 时间复杂度O(n)
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i ; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j]+ 1);
            }
        }
        return dp[n];
    }

    /**
     * 可以抽象为一个完全背包问题
     * 有1到根号n这么多物品，每个物品可以选多次，有一个容量大小为n的背包
     * 求恰好装满背包的最小物品数
     * dp[i][j]表示考虑前i个物品时，恰好装满容量为j的背包时的最小物品数
     * 不考虑i物品， dp[i][j] = dp[i - 1][j]
     * 放一次i，dp[i][j] = min(dp[i - 1][j - k * weight[i]] + k)
     * @param n
     * @return
     */
    public int numSquares2(int n) {
        if (n == 1) return 1;
        List<Integer> list = new ArrayList<>();
        int idx = 1;
        while (idx * idx <= n) {
            list.add(idx * idx);
            idx++;
        }

        int[][] dp = new int[list.size()][n + 1];

        //
        for (int j = 0; j <= n; j++) {
            int t = list.get(0);
            int k = j / t;
            if (k * t == j) {
                dp[0][j] = k;
            }
            else {
                dp[0][j] = -1;
            }
        }

        for (int i = 1; i < list.size(); i++) {
            int t = list.get(i);
            for (int j = 0; j <= n; j++) {
                int ans1 = dp[i - 1][j];
                int k = 1;
                int ans2 = n;
                while (k * t <= j) {
                    if (dp[i - 1][j - k * t] != -1) {
                        ans2 = Math.min(ans2, dp[i - 1][j - k * t] + k);
                    }
                    k++;
                }
                dp[i][j] = Math.min(ans1, ans2);
            }
        }
        return dp[list.size() - 1][n];
    }

    /**
     * 背包 空间优化
     * @param n
     * @return
     */
    public int numSquares3(int n) {
        if (n == 1) return 1;
        List<Integer> list = new ArrayList<>();
        int idx = 1;
        while (idx * idx <= n) {
            list.add(idx * idx);
            idx++;
        }

        int[][] dp = new int[2][n + 1];

        //初始化
        for (int j = 0; j <= n; j++) {
            int t = list.get(0);
            int k = j / t;
            if (k * t == j) {
                dp[0][j] = k;
            }
            else {
                dp[0][j] = -1;
            }
        }

        for (int i = 1; i < list.size(); i++) {
            int t = list.get(i);
            for (int j = 0; j <= n; j++) {
                int ans1 = dp[(i - 1) & 1][j];
                int k = 1;
                int ans2 = n;
                while (k * t <= j) {
                    if (dp[(i - 1) & 1][j - k * t] != -1) {
                        ans2 = Math.min(ans2, dp[(i - 1) & 1][j - k * t] + k);
                    }
                    k++;
                }
                dp[i & 1][j] = Math.min(ans1, ans2);
            }
        }
        return dp[(list.size() - 1) & 1][n];
    }


    /**
     * 一维数组优化
     * 时间复杂度O(n*根号n)
     * @param n
     * @return
     */
    public int numSquares4(int n) {
        if (n == 1) return 1;
        List<Integer> list = new ArrayList<>();
        int idx = 1;
        while (idx * idx <= n) {
            list.add(idx * idx);
            idx++;
        }

        int[] dp = new int[n + 1];

        //
        for (int j = 0; j <= n; j++) {
            int t = list.get(0);
            int k = j / t;
            if (k * t == j) {
                dp[j] = k;
            }
            else {
                dp[j] = -1;
            }
        }

        for (int i = 1; i < list.size(); i++) {
            int t = list.get(i);
            for (int j = t; j <= n; j++) {
                int ans = n;
                if (dp[j - t] != -1) {
                    ans = Math.min(ans, dp[j - t] + 1);
                }
                dp[j] = Math.min(dp[j], ans);
            }
        }
        return dp[n];
    }

    /**
     * 使用深度优先搜索
     * @param n
     * @return
     */
    List<List<Integer>> res = new ArrayList<>();
    int level = 1;
    public int numSquares5(int n) {
        if (n == 1) return 1;
        List<Integer> list = new ArrayList<>();
        int idx = 1;
        while (idx * idx <= n) {
            list.add(idx * idx);
            idx++;
        }

        bfs(list, n);
        return level;

/*        dfs(list, 0, n, new ArrayList<>());
        Collections.sort(res, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.size() - o2.size();
            }
        });
        return res.get(0).size();*/
    }

    /**
     * 使用广度优先搜索
     * 相当于n叉树的层序遍历，当节点值为0时，返回层数
     * @param list
     * @param sum
     */
    private void bfs(List<Integer> list, int sum) {
        Deque<Integer> deque = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        int n = list.size();
        for (int i = 0; i < n; i++) {
            int t = list.get(i);
            if (t == sum) return;
            deque.addLast(t);
            set.add(t);
        }
        while (!deque.isEmpty()) {
            int size = deque.size();
            level++;
            for (int i = 0; i < size; i++) {
                int head = deque.removeFirst();
                for (int j = 0; j < n; j++) {
                    int next = head + list.get(j);
                    if (next > sum) break;
                    if (next == sum){
                        return;
                    }
                    if (set.contains(next)) continue;
                    else set.add(next);
                    deque.addLast(next);
                }
            }

        }
    }

    private void dfs(List<Integer> list, int startIndex, int n, List<Integer> temp) {
        if (n == 0) {
            res.add(new ArrayList<>(temp));
        }
        if (n < 0) return;
        for (int i = startIndex; i < list.size(); i++) {
            int t = list.get(i);
            temp.add(t);
            dfs(list, i, n - t, temp);
            temp.remove(temp.size() - 1);
        }
    }


}
