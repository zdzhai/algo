package com.yugutou.charpter9_bitree_bisearch;

/**
 * leetcode 33.  搜索旋转排序数组
 * @author dongdong
 * @Date 2024/1/11 18:00
 */
public class Search {

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums, 0));
        System.out.println(search2(nums, 0));
    }

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int size = nums.length;
        if (size == 0) return 0;
        if (size == 1) return nums[0] == target ? 0 : -1;

        int left = 0, right = size - 1;
        while (left < right) {
            int mid = left + 1 +((right - left) >> 1);
            if (nums[mid] < nums[0]) {
                right = mid - 1;
            }
            else {
                left = mid;
            }
        }

        if (target >= nums[0]) {
            left = 0;
        } else {
            right = size - 1;
        }

        while (left < right) {
            int mid = left + 1 + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return nums[right] == target ? right : -1;
    }

    public static int search2(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) return nums[0] == target ? 0 : -1;

        // 第一次「二分」：从中间开始找，找到满足 >=nums[0] 的分割点（旋转点）
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] >= nums[0]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        // 第二次「二分」：通过和 nums[0] 进行比较，得知 target 是在旋转点的左边还是右边
        if (target >= nums[0]) {
            l = 0;
        } else {
            l = l + 1;
            r = n - 1;
        }
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return nums[r] == target ? r : -1;
    }
}
