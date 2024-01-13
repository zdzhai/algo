package com.yugutou.charpter9_bitree_bisearch;

/**
 * @author dongdong
 * @Date 2024/1/12 22:13
 */
public class FindMin {
    public static void main(String[] args) {
        int[] nums = {1,2};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int size = nums.length;
        if (size == 1) return nums[0];
        int left = 0, right = size - 1;
        while (left < right) {
            int mid = left + 1 + ((right - left) >> 1);
            if (nums[mid] < nums[0]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left + 1 < size ? nums[left + 1] : nums[0];
    }
}
