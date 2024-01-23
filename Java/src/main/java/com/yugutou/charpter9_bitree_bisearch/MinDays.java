package com.yugutou.charpter9_bitree_bisearch;

/**
 * leetcode. 1482.制作m束花所需的最少天数
 * @author dongdong
 * @Date 2024/1/13 10:33
 */
public class MinDays {
    public static void main(String[] args) {
        int[] bloomDay = {1,10,3,10,2};
        System.out.println(minDays(bloomDay, 3, 1));
    }

    /**
     * if m * k > bloomDay.length 直接返回-1
     * D的范围在bloomDay数组的min()和max()之间
     * 通过判断在此mid下，能得到几束花才减小区间
     * @param bloomDay
     * @param m
     * @param k
     * @return
     */
    public static int minDays(int[] bloomDay, int m, int k) {
        int size = bloomDay.length;
        if (m * k > size) return -1;
        int left = Integer.MAX_VALUE, right = 0;
        for (int i = 0; i < size; i++) {
            left = Math.min(left, bloomDay[i]);
            right = Math.max(right, bloomDay[i]);
        }
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            //在此天数下，能完成的花数小于m，需要增大天数
            if (!check(mid, bloomDay, m, k)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return check(left, bloomDay, m, k) ? left : -1;
    }

    /**
     * 在day天数下，每束花需要k支，能得到几束
     * 给一个宽度为k的滑动窗口，从左向右遍历
     * @param day
     * @param bloomDay
     * @param m
     * @param k
     * @return
     */
    private static boolean check(int day, int[] bloomDay, int m, int k) {
        int size = bloomDay.length;
        int l = 0, r;
        int get = 0;
        while (l < size) {
            int cur = bloomDay[l] <= day ? 1 : 0;
            r = l;
            if (cur > 0) {
                while (cur < k && r + 1 < size && bloomDay[r + 1] <= day) {
                    cur++;
                    r++;
                }
                if (cur == k) get++;
                l = r + 1;
            } else {
                l++;
            }
        }
        return get >= m;
    }

}
