package com.yugutou.charpter5_queue_hash;

import java.util.*;

/**
 * leetcode 217.存在重复元素
 * @author dongdong
 * @Date 2023/12/28 9:54
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate(nums));
        System.out.println(containsDuplicate2(nums));
        System.out.println(containsDuplicate3(nums));
    }

    /**
     * 使用map
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i] ,map.get(nums[i]) + 1);
                return true;
            } else {
                map.put(nums[i], 1);
            }
        }
        return false;
    }

    /**
     * 使用Set
     * @param nums
     * @return
     */
    public static boolean containsDuplicate2(int[] nums) {
        int n = nums.length;
        if (n == 1) return false;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }

    /**
     * 排序
     * @param nums
     * @return
     */
    public static boolean containsDuplicate3(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
}
