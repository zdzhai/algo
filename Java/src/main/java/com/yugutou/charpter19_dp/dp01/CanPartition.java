package com.yugutou.charpter19_dp.dp01;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 416.分割等和子集
 *
 * @author dongdong
 * @Date 2024/1/26 22:27
 */
public class CanPartition {
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        CanPartition canPartition = new CanPartition();
        System.out.println(canPartition.canPartition(nums));
        System.out.println(canPartition.canPartition2(nums));
        System.out.println(canPartition.canPartition3(nums));
        System.out.println(canPartition.canPartition4(nums));
        System.out.println(canPartition.canPartition5(nums));
    }

    /**
     * 在这些数字中能否找到满足其和恰好等于sum/2
     * 前i个数字中，总和不超过j的最大价值
     * 时间复杂度O(n*target)
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) != 0) return false;

        int target = sum >> 1;
        int[] dp = new int[target + 1];
        for (int i = 0; i <= target; i++) {
            dp[i] = i >= nums[0] ? nums[0] : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = target; j >= 0; j--) {
                if (j > nums[i]) {
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                }
            }
        }
        return dp[target] == target;
    }

    /**
     * 修改dp的定义为
     * 前i个数字中，其选择数字总和是否能恰好等于j
     *
     * @param nums
     * @return
     */
    public boolean canPartition2(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) != 0) return false;

        int target = sum >> 1;
        boolean[] dp = new boolean[target + 1];
        //0个 数的总和为0 true
        dp[0] = true;
        for (int i = 1; i < n; i++) {
            int t = nums[i - 1];
            for (int j = target; j >= 0; j--) {
                if (j >= t) {
                    dp[j] = dp[j] | dp[j - t];
                }
            }
        }
        return dp[target];
    }

    /**
     * 在一个数组中，不可以重复选择同一个元素，使得其选中的总和能够恰好等于总和的一半
     *
     * @param nums
     * @return
     */
    //记忆化搜索数组，表示数组中能否得到剩余i的组合
    boolean[] cache;
    public boolean canPartition3(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //总和为奇数，不可能拆分
        if ((sum & 1) != 0) return false;
        sum >>= 1;
        //将使用Map做记忆化该为直接使用boolean[]数组，
        // 因为Map的key其实存的就是remain对应于boolean[]数组的下标
        cache = new boolean[sum + 1];
        //Map<Integer, Boolean> cache = new HashMap<>();
        return dfs3(nums, 0, sum, cache);
    }

    /**
     * 如果剩余为0，则范围true
     * 如果剩余小于0，返回false
     *
     * @param nums
     * @param startIndex 第i个数
     * @param remain     剩余总和
     * @return
     */
    private boolean dfs3(int[] nums,
                         int startIndex,
                         int remain,
                         boolean[] cache) {
        if (remain == 0) return true;
        if (remain < 0) return false;

        //Integer k = remain << 9 | startIndex;
        //Integer k = remain;
        //如果能得到剩余remain（不为0）的组合，表明此组合是不可行的，
        if (cache[remain]) return true;

        for (int i = startIndex; i < nums.length; i++) {
            if (remain - nums[i] < 0) continue;
            boolean res = dfs3(nums, i + 1, remain - nums[i], cache);
            cache[remain] = res;
            if (res) {
                return true;
            }
        }
        return false;
    }




    /**
     * 使用dfs标记数组使用的方式进行遍历 相当于全排列
     * @param nums
     * @return
     */
    boolean[] used;
    boolean result;
    public boolean canPartition4(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //总和为奇数，不可能拆分
        if ((sum & 1) != 0) return false;
        sum >>= 1;
        used = new boolean[n];
        //记忆化搜索数组 表示能否得到剩余remain的组合
        Map<Integer, Boolean> cache = new HashMap<>();
        dfs4(nums, sum, used, cache);
        return result;
    }

    /**
     * @param nums
     * @param remain 剩余总和
     * @return
     */
    private void dfs4(int[] nums,
                      int remain,
                      boolean[] used,
                      Map<Integer, Boolean> cache) {
        if (remain == 0) {
            result = true;
            return;
        }

        if (cache.containsKey(remain)) {
            return;
        }

        if (!result) {
            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    if (remain - nums[i] >= 0) {
                        used[i] = true;
                        dfs4(nums, remain - nums[i], used, cache);
                        cache.put(remain, result);
                        used[i] = false;
                    }
                }
            }
        }
    }

    /**
     * 使用二叉树遍历思想
     *
     * @param nums
     * @return
     */
    public boolean canPartition5(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //总和为奇数，不可能拆分
        if ((sum & 1) != 0) return false;
        sum >>= 1;
        Map<Integer, Boolean> cache = new HashMap<>();
        return dfs5(nums, 0, sum, cache);
    }

    /**
     * 二叉树的前序遍历 但是会超时
     * 需要使用记忆化搜索优化，记录同一层的，节点值为remain时的状态。
     * 当再次在同一层得到该remain时，直接返回结果。
     * @param nums
     * @param startIndex
     * @param remain
     * @return
     */
    private boolean dfs5(int[] nums,
                         int startIndex,
                         int remain,
                         Map<Integer, Boolean> cache) {
        Integer k = remain << 9 | startIndex;
        if (remain == 0) return true;
        if (remain < 0 || startIndex == nums.length) return false;
        if (cache.containsKey(k)) return cache.get(k);
        boolean res = dfs5(nums, startIndex + 1, remain - nums[startIndex], cache) ||
                dfs5(nums, startIndex + 1, remain, cache);
        cache.put(k, res);
        return res;
    }
}
