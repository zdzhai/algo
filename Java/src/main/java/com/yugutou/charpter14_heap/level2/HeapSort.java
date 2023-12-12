package com.yugutou.charpter14_heap.level2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author dongdong
 * @Date 2023/12/11 19:58
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] nums = {12,23,54,2,65,45,92,47,204,31};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 用小顶堆实现
     * @param nums
     */
    public static void heapSort(int[] nums) {
        int n = nums.length;
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(nums[i]);
        }
        int t = 0;
        while (!pq.isEmpty()) {
            nums[t++] = pq.poll();
        }
    }
}
