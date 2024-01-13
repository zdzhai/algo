package com.yugutou.charpter9_bitree_bisearch;

/**
 * leetcode 162.寻找峰值
 * @author dongdong
 * @Date 2024/1/10 20:53
 */
public class FindPeakElement {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(findPeakElement2(nums));
    }

    /**
     * if(nums[mid ])
     * @param nums
     * @return
     */
    public static int findPeakElement(int[] nums) {
        int size = nums.length;
        if (size == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return size - 1;
    }

    /**
     * if(nums[mid] > nums[mid + 1]) right = mid
     * if(nums[i] < nums[i + 1) left = mid + 1
     *
     * @param nums
     * @return
     */
    public static int findPeakElement2(int[] nums) {
        int size = nums.length;
        if (size == 1) return 0;
        int left = 0, right = size - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }
        }
        return right;
    }

}
