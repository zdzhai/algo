package com.yugutou.charpter3_array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dongdong
 * @Date 2024/6/12 20:14
 * leetcode 1.两数之和
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }

    /**
     *
     * @param nums
     * @param t
     * @return
     * 时间复杂度O(n)
     */

    public static int[] twoSum(int[] nums, int t) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int temp = t - nums[i];
            if (map.containsKey(temp)) {
                ans[0] = map.get(temp);
                ans[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return ans;
    }
}
