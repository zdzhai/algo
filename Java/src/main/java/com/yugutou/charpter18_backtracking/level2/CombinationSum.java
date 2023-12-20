package com.yugutou.charpter18_backtracking.level2;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode39
 */
public class CombinationSum {

    List<List<Integer>> res = new ArrayList<>(); //记录答案
    List<Integer> path = new ArrayList<>();  //记录当前正在访问的路径

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, 0, target);
        return res;
    }

    public void dfs(int[] c, int startIndex, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < c.length; i++) {
            if (c[i] <= target) {
                path.add(c[i]);
                target -= c[i];
                dfs(c, i, target);
                target += path.get(path.size() - 1);
                path.remove(path.size() -1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> result = combinationSum.combinationSum(candidates, target);
        System.out.println(result);
    }
}
