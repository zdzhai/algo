package com.yugutou.charpter3_array;

import java.util.Random;

/**
 * leetcode 384.打乱数组
 * @author dongdong
 * @Date 2024/1/18 21:28
 */
public class Solution {

    int[] nums;
    boolean[] flag;
    Random random = new Random();

    public Solution(int[] nums) {
        this.nums = nums;
        this.flag = new boolean[nums.length];
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int n = nums.length;
        int[] res = nums.clone();
        for (int i = 0; i < n; i++) {
            swap(res, i, i + random.nextInt(n - i));
        }
        return res;
    }

    private void swap(int[] res, int i, int nextInt) {
        int a = res[i];
        res[i] = res[nextInt];
        res[nextInt] = a;
    }
}
