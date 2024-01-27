package com.yugutou.charpter19_dp;

import java.util.Arrays;

/**
 * leetcode 1575.统计所有可行路径
 * @author dongdong
 * @Date 2024/1/25 19:32
 */
public class CountRoutes {
    public static void main(String[] args) {
        CountRoutes countRoutes = new CountRoutes();
        int[] ls = {4,3,1};
        int sum = countRoutes.countRoutes(ls, 1, 0, 6);
        System.out.println(sum);
    }

    //记录从位置i出发，剩余油量为fuel的情况下，到达目标地点的路径总数
    int[][] cache;
    int mod = 1000000007;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;

        cache = new int[n][fuel + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(cache[i], -1);
        }
        return dfs(locations, start, finish, fuel);
    }

    /**
     * 当前位置就是结束位置，递归结束
     * 油量为0,但是不在结束位置，或者 油量不为0，但是已经走不动了 也是递归结束
     *
     * 在位置start出发，油量为fuel的前提下，到达finish的路径数
     * @return
     */
    public int dfs(int[] locations, int start, int finish, int fuel) {

        //如果缓存中已经有结果，直接返回
        if (cache[start][fuel] != -1) {
            return cache[start][fuel];
        }

        int need = Math.abs(locations[start] - locations[finish]);
        if (need > fuel) {
            cache[start][fuel] = 0;
            return 0;
        }

        int n = locations.length;

        if (fuel == 0 && start != finish) {
          cache[start][fuel] = 0;
          return 0;
        }

        boolean canMove = false;
        for (int i = 0; i < n; i++) {
            if (i != start) {
                int num = Math.abs(locations[i] - locations[start]);
                if (fuel >= num) {
                    canMove = true;
                    break;
                }
            }
        }

        if (fuel != 0 && !canMove) {
            int a = cache[start][fuel] = start == finish ? 1 : 0;
            return a;
        }

        int sum = finish == start ? 1 : 0;
        for (int i = 0; i < n; i++) {
            if (i != start) {
                need = Math.abs(locations[i] - locations[start]);
                if (fuel >= need) {
                    sum += dfs(locations, i, finish, fuel - need);
                    sum %= mod;
                }
            }
        }
        cache[start][fuel] = sum;
        return sum;
    }
}
