package com.yugutou.charpter10_quicksort;

import java.util.Arrays;

/**
 * @author dongdong
 * @Date 2023/12/3 12:45
 * 归并查找
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 3, 7, 6, 1, 8, 4};
        mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
        System.out.println(Arrays.toString(arr));
    }
    public static void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        mergeSort(nums, left, mid, temp);
        mergeSort(nums,mid + 1, right, temp);
        merge(nums, left, right, temp);
    }

    private static void merge(int[] nums, int left, int right, int[] temp) {
        int mid = (left + right) / 2;
        int i = left;
        int j = mid + 1;
        int t = left;
        while (i <= mid && j <= right) {
            if (nums[i] >= nums[j]) {
                temp[t++] = nums[j++];
            } else {
                temp[t++] = nums[i++];
            }
        }
        while (i <= mid) {
            temp[t++] = nums[i++];
        }
        while (j <= right) {
            temp[t++] = nums[j++];
        }
        for (int k = left; k <= right; k++) {
            nums[k] = temp[k];
        }
    }


}
