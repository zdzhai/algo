package com.yugutou.charpter5_queue_hash.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] res = {0,0};
        Map<Integer, Integer> map  = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int temp = target - nums[i];
            if (!map.containsKey(temp)) {
                map.put(nums[i], i);
            } else {
                res[0] = i;
                res[1] = map.get(temp);
                break;
            }
        }
        return res;
    }

    //第二种实现方式
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
