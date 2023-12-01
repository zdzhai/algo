package com.yugutou.charpter9_bitree_bisearch.level2;

/**
 * LeetCode153 旋转数字的最小数字
 */
public class FindMin {
    public static void main(String[] args) {
        int[] nums = {2,3,4,5,1};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
