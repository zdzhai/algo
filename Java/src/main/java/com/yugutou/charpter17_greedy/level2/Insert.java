package com.yugutou.charpter17_greedy.level2;

import java.util.Arrays;

public class Insert {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] result = insert(intervals, newInterval);
        for (int[] nums : result) {
            System.out.println(Arrays.toString(nums));
        }

    }

    /**
     * 先把结尾处小于新增区间初始的加入到ans
     * 对重复/新增区间做判断
     * 把开始点大于上一节点后的节点加入到ans
     * @param intervals
     * @param newInterval
     * @return
     */
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] ans = new int[intervals.length + 1][2];
        int t = 0;
        int i = 0;
        // 先把结尾处小于新增区间初始的加入到ans
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            ans[t++] = intervals[i++];
        }
        // 对重复/新增区间做判断
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i++][1], newInterval[1]);
        }
        ans[t++] = newInterval;
        // 把开始点大于上一节点后的节点加入到ans
        while (i < intervals.length && intervals[i][0] > newInterval[1]) {
            ans[t++] = intervals[i++];
        }
        return Arrays.copyOf(ans, t);
    }
}
