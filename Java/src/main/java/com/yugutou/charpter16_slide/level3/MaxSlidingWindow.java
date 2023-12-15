package com.yugutou.charpter16_slide.level3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * LeetCode239  滑动窗口最大值
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow2(nums, k);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 超时了，思考是因为堆中做了太多了remove导致堆化占了很多时间
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Queue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int[] ans = new int[n - k + 1];
        int t = 0;
        int left = 0, right = k - 1;
        for (int i = 0; i <= right; i++) {
            pq.offer(nums[i]);
        }
        ans[t++] = pq.peek();
        while (right < n - 1) {
            pq.remove(nums[left++]);
            pq.offer(nums[++right]);
            ans[t++] = pq.peek();
        }
        return ans;
    }

    /**
     * 优先队列记录数和索引，减少重新堆化
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });
        int[] ans = new int[n - k + 1];
        int t = 0;
        int left = 0, right = k - 1;
        for (int i = 0; i <= right; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        ans[t++] = pq.peek()[0];
        right = k;
        while (right < n) {
            pq.offer(new int[]{ nums[right], right});
            while (pq.peek()[1] <= right - k) {
                pq.poll();
            }
            ans[t++] = pq.peek()[0];
            right++;
        }
        return ans;
    }
}
