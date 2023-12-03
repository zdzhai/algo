package com.yugutou.charpter10_quicksort;

import java.util.Arrays;

/**
 *
 */
public class QuickSortBasic {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 3, 7, 6, 1, 8, 4};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left;
        int r = right;
        int temp = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= temp) {
                right--;
            }
            if (left < right) {
                arr[left++] = arr[right];
            }
            while (left < right && arr[left] < temp) {
                left++;
            }
            if (left < right) {
                arr[right--] = arr[left];
            }
        }
        arr[left] = temp;
        quickSort(arr, l, left - 1);
        quickSort(arr, left + 1, r);
    }


}
