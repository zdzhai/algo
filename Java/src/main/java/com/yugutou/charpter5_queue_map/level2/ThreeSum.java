package com.yugutou.charpter5_queue_map.level2;

import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int a = 0, b = 1, c = n - 1;
        List<List<Integer>> list = new ArrayList<>();

        for (a = 0; a < n; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            if (nums[a] > 0) {
                break;
            }
            b = a + 1;
            c = n - 1;
            while (b < c) {
                int sum = nums[a] + nums[b] + nums[c];
                if (sum > 0) {
                    c--;
                    continue;
                } else if (sum < 0) {
                    b++;
                    continue;
                } else {
                    list.add(Arrays.asList(nums[a], nums[b], nums[c]));
                    while (b < c && nums[c] == nums[c - 1]) {
                        c--;
                    }
                    while (b < c && nums[b] == nums[b + 1]) {
                        b++;
                    }
                }
                c--;
                b++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[]nums = {-1,0,1,2,-1,-4};
        //int[] nums = {0, 0, 0,0,0};
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result);
    }
}
