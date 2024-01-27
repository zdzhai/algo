package com.yugutou.charpter9_bitree_bisearch;

/**
 * leetcode 528.按权重随机选择
 * @author dongdong
 * @Date 2024/1/24 21:10
 */
public class Solution {
    public static void main(String[] args) {

    }
    int[] sum;
    public Solution(int[] w) {
        int n = w.length;
        this.sum = new int[n + 1];
        //前缀和就是其概率分布序列
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + w[i - 1];
        }
    }

    public int pickIndex() {
        int n = sum.length;
        int t = (int) (Math.random() * sum[n - 1]) + 1;
        int l = 1, r = n - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (sum[mid] < t) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r - 1;
    }

}
