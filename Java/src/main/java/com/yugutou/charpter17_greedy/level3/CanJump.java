package com.yugutou.charpter17_greedy.level3;

/**
 * leetCode 55 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度，判断你是否能够到达最后一个位置。
 */
public class CanJump {
    public static void main(String[] args) {
        int[] nums = {2,0,0};
        System.out.println(canJump(nums));
        System.out.println(canJump2(nums));
    }

    /**
     *
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover, nums[i] + i);
            if (cover >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * dp[i]表示到i时最大剩余步数
     * if(dp[i - 1] > 0)
     * dp[i] = max(dp[i-1] - 1 , nums[i] )
     * @param nums
     * @return
     */
    public static boolean canJump2(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if( dp[i - 1] > 0 ) {
                dp[i] = Math.max(dp[i - 1] - 1 , nums[i] );
            } else {
                return false;
            }
        }
        return dp[n - 1] >= 0;
    }
}
