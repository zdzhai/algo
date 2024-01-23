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

    /**
     * 先找到旋转点
     * 旋转点存在这样的关系
     * 旋转点左边的数都大于nums[0],旋转点右边的数都小于nums[0]
     * 如果nums[mid] > nums[0],左边界收缩
     * 如果nums[mid] < nums[0],右边界收缩
     * 再判断target和旋转点的关系进行二分查找
     * @param nums
     * @param target
     * @return
     */
    public static int search2(int[] nums, int target) {
        int n = nums.length;
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] < nums[0]) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }

        if (target >= nums[0]) {
            l = 0;
        } else {
            l += 1;
            r = n - 1;
        }

        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }

        return nums[r] == target ? l : -1;
    }
}
