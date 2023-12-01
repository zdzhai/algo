package com.yugutou.charpter9_bitree_bisearch.level2;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 */
public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 9};
        System.out.println(solve(nums));
    }

    /**
     * 如果nums[i] != i right = mid - 1;
     * 如果nums[i] == i left = mid + 1;
     * @param a
     * @return
     */
    public static int solve(int[] a) {
        // write code here
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (a[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
