package com.yugutou.charpter9_bitree_bisearch;

import java.util.Arrays;

/**
 * leetcode. 34.在排序数组中查找元素的第一个和最后一个位置
 * @author dongdong
 * @Date 2024/1/12 20:43
 */
public class SearchRange {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(nums, 6)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        int size = nums.length;
        if (size == 0) return ans;
        int left = 0, right = size - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        ans[0] = nums[left] == target ? left : -1;

        left = 0;
        right = size - 1;
        while (left < right) {
            int mid = left + 1 + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else  {
                left = mid;
            }
        }
        ans[1] = nums[left] == target ? left : -1;
        return ans;
    }
}
