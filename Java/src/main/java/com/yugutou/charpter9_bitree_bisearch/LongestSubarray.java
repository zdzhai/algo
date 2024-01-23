package com.yugutou.charpter9_bitree_bisearch;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * leetcode 1438.绝对差不超过限制的最长连续子数组
 *
 * @author dongdong
 * @Date 2024/1/21 10:17
 */
public class LongestSubarray {
    public static void main(String[] args) {
        int[] nums = {8,2,4,7};
        System.out.println(longestSubarray2(nums,4));
        System.out.println(longestSubarray(nums,4));
    }

    /**
     * 假设最长连续子数组的长度为len，则有存在不超过len长度的条件数组
     * 一定不存在大于len长度的条件数组，len减小
     * 所以可以使用二分
     * 1 <= nums.length <= 10^5
     * 题目数据范围为10^5，所以只能线性或者nlogn
     *
     * @param nums
     * @param limit
     * @return
     */
    public static int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        //最大为整个数组长度，最小为1
        int l = 1, r = n;
        while (l < r) {
            int mid = l + 1 + ((r - l) >> 1);
            //true为存在小于等于len的条件数组，mid可以保持不变
            //false一定不存在大于len的条件数组，mid必须减小
            if (!check(nums, mid, limit)) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return r;
    }

    /**
     * 判断数组中是否存在长度为len的连续的绝对差不超过limit的连续子数组
     * 时间复杂度O(nlogn)
     * 空间复杂度O(n)
     */
    private static boolean check(int[] nums, int len, int limit) {
        int n = nums.length;
        //单调队列记录当前范围内的最大值和最小值
        Deque<Integer> max = new ArrayDeque<>(), min = new ArrayDeque<>();

        for (int r = 0, l = r - len + 1; r < n; r++, l = r - len + 1) {
            if (!max.isEmpty() && max.peekFirst() < l) {
                max.pollFirst();
            }
            while (!max.isEmpty() && nums[r] >= nums[max.peekLast()]) {
                max.pollLast();
            }
            max.addLast(r);

            if (!min.isEmpty() && min.peekFirst() < l) {
                min.pollFirst();
            }
            while (!min.isEmpty() && nums[r] <= nums[min.peekLast()]) {
                min.pollLast();
            }
            min.addLast(r);

            if (l >= 0 && Math.abs(nums[max.peekFirst()] - nums[min.peekFirst()]) <= limit) {
                return true;
            }
        }
        return false;
    }

    /**
     * 滑动窗口，但需要实时判断窗口内的最大最小值
     * 使用双端单调队列来实时判断
     * 时间复杂度O(n)
     * 间复杂度O(n)
     * @param nums
     * @param limit
     * @return
     */
    public static int longestSubarray2(int[] nums, int limit) {
        int n = nums.length;
        int ans = 0;
        Deque<Integer> max = new ArrayDeque<>(), min = new ArrayDeque<>();
        for (int r = 0, l = 0; r < n; r++) {
            while (!max.isEmpty() && nums[r] >= nums[max.peekLast()]) {
                max.pollLast();
            }
            max.addLast(r);

            while (!min.isEmpty() && nums[r] <= nums[min.peekLast()]) {
                min.pollLast();
            }
            min.addLast(r);

            while (Math.abs(nums[max.peekFirst()] - nums[min.peekFirst()]) > limit) {
                l++;
                if (max.peekFirst() < l) max.pollFirst();
                if (min.peekFirst() < l) min.pollFirst();
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
