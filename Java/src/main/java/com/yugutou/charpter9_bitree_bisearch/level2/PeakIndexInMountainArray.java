package com.yugutou.charpter9_bitree_bisearch.level2;

/**
 * LeetCode852.山峰数组，
 * 在数组中的某位位置i开始，从0到i是递增的，从i+1 到数组最后是递减的，让你找到这个最高点。
 */
public class PeakIndexInMountainArray {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0};
        System.out.println(peakIndexInMountainArray2(arr));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 如果nums[i] > nums[i - 1] && nums[i] < nums[i + 1] left = mid + 1
     * 如果nums[i] < nums[i - 1] && nums[i] > nums[i + 1] right = mid - 1
     * 如果nums[i] > nums[i - 1] && nums[i] > nums[i + 1] return mid
     * @param arr
     * @return
     */
    public static int peakIndexInMountainArray2(int[] arr) {
        if (arr.length == 3) {
            return 1;
        }

        int n = arr.length;
        int left = 0;
        int right = n - 2;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            }
        }
        return -1;
    }
}
