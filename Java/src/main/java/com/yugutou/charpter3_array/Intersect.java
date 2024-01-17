package com.yugutou.charpter3_array;

import java.util.*;

/**
 * leetcode 350. 两个数组的交集2
 *
 * @author dongdong
 * @Date 2024/1/17 19:38
 */
public class Intersect {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(intersect2(nums1, nums2)));
    }

    /**
     * 使用两个hashMap,存放数字和个数
     * 遍历其中一个（小的），看在另一个是是否存在，然后比大小
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i : nums1) {
            if (!map1.containsKey(i)) {
                map1.put(i, 1);
            } else {
                Integer num = map1.get(i);
                map1.put(i, ++num);
            }
        }
        for (int i : nums2) {
            if (!map2.containsKey(i)) {
                map2.put(i, 1);
            } else {
                Integer num = map2.get(i);
                map2.put(i, ++num);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey())) {
                int v1 = entry.getValue(), v2 = map2.get(entry.getKey());
                int num = Math.min(v1, v2);
                while (num-- > 0) {
                    list.add(entry.getKey());
                }
            }
        }
        int[] ans = new int[list.size()];
        int i = 0;
        for (Integer integer : list) {
            ans[i++] = integer;
        }
        return ans;
    }

    public static int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int size1 = nums1.length, size2 = nums2.length;
        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < size1 && j < size2) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] ans = new int[list.size()];
        i = 0;
        for (Integer integer : list) {
            ans[i++] = integer;
        }
        return ans;
    }
}
