package com.yugutou.charpter11_bit.level2;

/**
 * leetcode 287. 寻找重复数
 * @author dongdong
 * @Date 2024/1/14 21:19
 */
public class FindDuplicate {
    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2};
        System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {
        int ans = 0;
        int size = nums.length;
        for (int i = 1; i < size; i++) {
            ans ^= i;
        }
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
