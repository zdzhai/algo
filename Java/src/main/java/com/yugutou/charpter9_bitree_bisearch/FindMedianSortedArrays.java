package com.yugutou.charpter9_bitree_bisearch;

/**
 * leetcode 4.寻找两个正序数组的中位数
 * @author dongdong
 * @Date 2024/1/20 16:56
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {

    }

    /**
     * 寻找数组中第tot/2小和（tot - 1）/2小的数
     * 如果小于等于mid的数小于k,说明mid小了
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int k = (m + n) / 2;
        int l = 0;
        return 0.0;
    }
}
