package com.yugutou.charpter11_bit.level2;

/**
 * leetcode 268.丢失的数字
 * @author dongdong
 * @Date 2024/1/14 20:56
 */
public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(missingNumber(nums));
        System.out.println(missingNumber2(nums));
    }

    /**
     * 遍历一遍nums求和，同时对i求和
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        int size = nums.length;
        int sum = 0, target = 0;
        for (int i = 0; i < size; i++) {
            sum += nums[i];
            target += i;
        }
        return target + size - sum;
    }

    /**
     * 找缺失数，出现一次的数，都是异或的经典应用
     * a ^ a = 0, a ^ 0 = a;
     * @param nums
     * @return
     */
    public static int missingNumber2(int[] nums) {
        int size = nums.length;
        int ans = 0;
        for (int i = 0; i <= size; i++) {
            ans ^= i;
        }
        for (int i = 0; i < size; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}
