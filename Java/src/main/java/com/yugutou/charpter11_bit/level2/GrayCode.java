package com.yugutou.charpter11_bit.level2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dongdong
 * @Date 2023/12/31 10:56
 */
public class GrayCode {
    static List<Integer> ans = new ArrayList<>();
    static boolean flag = false;
    public static void main(String[] args) {
        System.out.println(grayCode(3));
        System.out.println(grayCode2(3));
    }

    /**
     * 用回溯写
     * @param n
     * @return
     */
    public static List<Integer> grayCode(int n) {
        ans = new ArrayList<>();
        flag = false;
        int limit = (int) Math.pow(2,n);
        ans.add(0);
        int[] map = new int[limit];
        map[0] = 1;
        dfs(0, limit,n, map);
        return ans;
    }

    public static void dfs(int current, int limit, int n, int[] map) {
        if (ans.size() == limit && Integer.bitCount(current) == 1) {
            flag = true;
            return;
        }
        for (int i = 0; i < n; i++) {
            int next = current ^ (1 << i);
            if (map[next] == 0) {
                map[next] = 1;
                ans.add(next);
                dfs(next,limit,n,map);
                if (flag) return;
                map[next] = 0;
                ans.remove(ans.size() - 1);
            }
        }
    }

    /**
     * 非常巧的方法 镜像法
     * 0 | 1
     * 00 01 |11 10
     * 00 01 11 10 | 110 111 101 100
     * @param n
     * @return
     */
    public static List<Integer> grayCode2(int n) {
        ans = new ArrayList<Integer>(){{ ans.add(0);}};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = ans.size() - 1; j >= 0; j--) {
                ans.add(ans.get(j) + head);
            }
            head <<= 1;
        }
        return ans;
    }
}
