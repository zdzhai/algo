package com.yugutou.charpter10_quicksort;

public class Kth {
    public static void main(String[] args) {
        //int[] array = {6, 3, 2, 4, 5, 8, 7};
       int[] array = {3, 2, 1, 5, 6, 4};
        int k = 2;//找第二大元素
        int n = array.length;
        quickSort(array, 0, n - 1, n - k);
        System.out.println(array[n - k]);  //因为是从零开始所以k-1;

    }

    public static int quickSort(int[] nums, int left, int right, int k) {
        if (left >= right) {
            return nums[k];
        }
        int start = left;
        int end = right;
        int temp = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= temp) {
                right--;
            }
            if (left < right) {
                nums[left++] = nums[right];
            }
            while (left < right && nums[left] < temp) {
                left++;
            }
            if (left < right) {
                nums[right--] = nums[left];
            }
        }
        nums[left] = temp;
        if (k <= left) {
            return quickSort(nums, start, left - 1, k);
        } else {
            return quickSort(nums, left + 1, end, k);
        }
    }
}
