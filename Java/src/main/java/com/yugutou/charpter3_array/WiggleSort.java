package com.yugutou.charpter3_array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * leetcode 324.摆动排序2 未完成
 * @author dongdong
 * @Date 2024/1/16 19:26
 */
public class WiggleSort {
    public static void main(String[] args) {
        int[] nums = {1,5,1,1,6,4};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 先找出数组的一半较小值
     * 使用优先队列（堆）
     * 一个放小值，一个放大值，依次出队列，知道数组被填满
     * @param nums
     */
    public static void wiggleSort(int[] nums) {
        int size = nums.length;
        if (size == 1) return;
        //最小堆
        Queue<Integer> small = new PriorityQueue<>(size / 2 + 1, (a,b) -> a - b);
        //最大堆
        Queue<Integer> big = new PriorityQueue<>(size / 2 + 1, (a,b) -> b - a);
        for (int num : nums) {
            small.add(num);
            big.add(num);
        }
        for (int i = 0; i < size; i++) {
            nums[i] = i % 2 == 0 ? small.poll() : big.poll();
        }
    }
}
