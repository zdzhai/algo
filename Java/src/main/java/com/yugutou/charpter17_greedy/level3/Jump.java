package com.yugutou.charpter17_greedy.level3;

/**
 * LeetCode45 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 假设一定能到达末尾，然后让你求最少到达的步数该怎么办呢？
 */
public class Jump {
    public static void main(String[] args) {
        int[] nums = {7,0,9,6,9,6,1,6,9,0,1,2,9,0,3};
        System.out.println(jump(nums));
        System.out.println(jump2(nums));
    }

    public static int jump(int[] nums) {
        int right = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int left = 0; left < nums.length - 1; left++) {
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[left] + left);
            if (left == right) { //遇到边界，就更新边界，并且步数加一
                right = maxPosition;
                steps++;
            }
            //right指针到达末尾了。
            if (right >= nums.length - 1) {
                return steps;
            }
        }
        return steps;
    }

    /**
     * dp[i]表示能跳到此位置的最小跳跃次数
     * if ( nums[i - 1] - i >= 0)
     * dp[i] = min(dp[i - 1], 1);
     * @param nums
     * @return
     */
    public static int jump2(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int cover = 0;
        int step = 0;
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //总共能跳的最远距离
            max = Math.max(max, nums[i] + i);
            //cover 更新能达到的最远距离
            if (i == cover) {
                cover = max;
                step++;
            }
            if (cover >= n - 1) {
                return step;
            }
        }
        return step;
    }
}
