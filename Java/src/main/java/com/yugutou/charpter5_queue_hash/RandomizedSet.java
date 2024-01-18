package com.yugutou.charpter5_queue_hash;

import java.util.*;

/**
 * leetcode. 380 0(1)时间插入、删除和获取随机元素
 */
class RandomizedSet {

    Map<Integer, Integer> map = new HashMap<>();
    int[] nums = new int[20001];
    Random random = new Random();
    int idx = -1;

    public RandomizedSet() {
    }

    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            nums[++idx] = val;
            map.put(val, idx);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            Integer loc = map.remove(val);
            if (loc != idx) {
                map.put(nums[idx], loc);
            }
            nums[loc] = nums[idx--];
            return true;
        }
        return false;
    }

    public int getRandom() {
        return nums[random.nextInt(idx + 1)];
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(1);
        randomizedSet.remove(2);
        randomizedSet.insert(2);
        int random = randomizedSet.getRandom();
        randomizedSet.remove(1);
        randomizedSet.insert(2);
        int random1 = randomizedSet.getRandom();
        System.out.println();
    }
}