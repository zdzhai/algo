package com.yugutou.charpter9_bitree_bisearch;

/**
 * leetcode 81.搜索旋转数组 2
 * @author dongdong
 * @Date 2024/1/12 21:09
 */
public class Search2 {
    public static void main(String[] args) {
        int[] nums = {2,2,2,3,2,2,2};
        System.out.println(search(nums, 3));
        System.out.println(search2(nums, 3));
    }

    public static boolean search(int[] nums, int target) {
        int size = nums.length;
        int left = 0, right = size - 1;
        //恢复二分查找的二段性
        while (left < right && nums[left] == nums[right]) {
            right--;
        }
        int r = right;

        while (left < right) {
            int mid = left + 1 + ((right - left) >> 1);
            if (nums[mid] < nums[0]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        if (target >= nums[0]) {
            left = 0;
        } else {
            left++;
            right = r;
            if (left > right) {
                return false;
            }
        }

        while (left < right) {
            int mid = left + 1 + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return nums[left] == target;
    }

    public static boolean search2(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return nums[0] == target;
        }

        //恢复二段性，否则无法二分
        int l = 0, r = n - 1;
        while (l < r && nums[0] == nums[r]) {
            r--;
        }
        int mr = r;

        //二分找旋转点
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] >= nums[0]) {
                l = mid;
            }
            else {
                r = mid - 1;
            }
        }

        if (target >= nums[0]) {
            l = 0;
        }
        else {
            l++;
            r = mr;
            if (l > r) {
                return false;
            }
        }

        //二分求解
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return nums[l] == target;
    }
}
