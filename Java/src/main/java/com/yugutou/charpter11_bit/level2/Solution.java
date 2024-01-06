package com.yugutou.charpter11_bit.level2;

/**
 * leetcode 2980. 检查按位或是否存在尾随零
 */
class Solution {
    public static void main(String[] args) {
        int[] nums = {2,2};
        System.out.println(hasTrailingZeros(nums));
    }
    public static boolean hasTrailingZeros(int[] nums) {
        int ans = 0;
        for(int i : nums) {
            if (ans >= 2) {
                return true;
            }
             if ( (i & 1) == 0 ) {
                 ans++;
             }
        }

        return ans >= 2;
    }
}