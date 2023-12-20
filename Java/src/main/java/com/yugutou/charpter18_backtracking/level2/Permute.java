package com.yugutou.charpter18_backtracking.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode46
 */
class Permute {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return result;
        }
        used = new boolean[nums.length];
        permuteHelper(nums);
        return result;
    }

    private void permuteHelper(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                permuteHelper(nums);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permute permute = new Permute();
        System.out.println(permute.permute(nums));
    }
}
