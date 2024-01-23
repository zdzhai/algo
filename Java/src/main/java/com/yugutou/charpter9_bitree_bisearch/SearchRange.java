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


    public static int[] searchRange2(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[2];
        ans[0] = -1; ans[1] = -1;
        if (n == 0) return ans;
        int l = 0, r = n - 1;

        //查找大于等于target的第一个元素
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            //当nums[mid]大于等于target
            // nums[mid] < target，左边界增加
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        ans[0] = nums[r] == target ? r : -1;

        l = 0; r = n - 1;
        //查找小于等于target的最后一个元素
        while (l < r) {
            int mid = l + 1 + ((r - l) >> 1);
            //当nums[mid]小于等于target
            // nums[mid] > target，右边界减小
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        ans[1] = nums[r] == target ? r : -1;
        return ans;
    }
}
