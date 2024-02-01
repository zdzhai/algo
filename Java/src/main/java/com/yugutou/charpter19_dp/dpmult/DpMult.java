package com.yugutou.charpter19_dp.dpmult;

import java.util.ArrayList;
import java.util.List;

/**
 * 多重背包
 * @author dongdong
 * @Date 2024/1/30 19:04
 */
public class DpMult {
    public static void main(String[] args) {

    }

    /**
     * 选1个第i个物品 dp[i][j] = dp[i - 1][j - weight[i]] + value[i];
     * 选k个第i个物品 dp[i][j] = dp[i - 1][j - k * weight[i]] + k * value[i];
     * k <= nums[i]
     * @param weight
     * @param value
     * @param nums
     * @param V
     * @return
     */
    public int maxValue(int[] weight, int[] value, int[] nums, int V) {
        int n = weight.length;
        int[][] dp = new int[n][V + 1];

        for (int j = 0; j <= V; j++) {
            int t = weight[0];
            int min = j / t;
            min = Math.min(min, nums[0]);
            dp[0][j] = min * value[0];
        }

        for (int i = 1; i < n; i++) {
            int t = weight[i];
            for (int j = 0; j <= V; j++) {
                int x = dp[i - 1][j];
                int y = 0;
                for (int k = 1; k <= nums[i] && j >= k * t; k++) {
                    y = Math.max(y,
                            dp[i - 1][j - k * t] + k * value[i]);
                }
                dp[i][j] = Math.max(x, y);
            }
        }
        return dp[n - 1][V];
    }

    /**
     * 滚动数组
     * @param weight
     * @param value
     * @param nums
     * @param V
     * @return
     */
    public int maxValue2(int[] weight, int[] value, int[] nums, int V) {
        int n = weight.length;
        int[][] dp = new int[2][V + 1];

        for (int j = 0; j <= V; j++) {
            int t = weight[0];
            int min = j / t;
            min = Math.min(min, nums[0]);
            dp[0][j] = min * value[0];
        }

        for (int i = 1; i < n; i++) {
            int t = weight[i];
            for (int j = 0; j <= V; j++) {
                int x = dp[(i - 1) & 1][j];
                int y = 0;
                for (int k = 1; k <= nums[i] && j >= k * t; k++) {
                    y = Math.max(y,
                            dp[(i - 1) & 1][j - k * t] + k * value[i]);
                }
                dp[i & 1][j] = Math.max(x, y);
            }
        }
        return dp[(n - 1) & 1][V];
    }

    /**
     * 一维数组优化
     *
     * @param weight
     * @param value
     * @param nums
     * @param V
     * @return
     */
    public int maxValue3(int[] weight, int[] value, int[] nums, int V) {
        int n = weight.length;
        int[] dp = new int[V + 1];

        for (int j = 0; j <= V; j++) {
            int t = weight[0];
            int min = j / t;
            min = Math.min(min, nums[0]);
            dp[j] = min * value[0];
        }

        for (int i = 1; i < n; i++) {
            int t = weight[i];
            for (int j = V; j >= t; j--) {
                for (int k = 0; k <= nums[i] && j >= k * t; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * t] + k * value[i]);
                }
            }
        }
        return dp[V];
    }

    /**
     * 转换为01背包优化
     * 就是将数组扁平化，把个数为nums[i]的weight物品全部拆开为独立物品
     * 时间复杂度sum(nums[i]) * V
     * @param weight
     * @param value
     * @param nums
     * @param V
     * @return
     */
    public int maxValue4(int[] weight, int[] value, int[] nums, int V) {
        List<int[]> arr = new ArrayList<>();
        int n = weight.length;
        for (int i = 0; i < n; i++) {
            int count = nums[i];
            while (count-- > 0) {
                arr.add(new int[]{weight[i], value[i]});
            }
        }

        //使用01背包
        int[] dp = new int[V + 1];
        //初始化
        for (int j = 0; j <= V; j++) {
            dp[j] = j >= arr.get(0)[0] ? arr.get(0)[1] : 0;
        }

        for (int i = 1; i < n; i++) {
            int wi = arr.get(i)[0], vi = arr.get(i)[1];
            for (int j = V; j >= wi; j--) {
                dp[j] = Math.max(dp[j], dp[j - wi] + vi);
            }
        }
        return dp[V];
    }

    /**
     * 使用二进制优化完全背包，核心思想仍然是扁平化数组
     * 受linux文件权限的启发，r(1)w(2)x(4)可以表示8种权限操作
     * 因为我们也可以使用1248来试试物品的数量*价值
     * 可以使时间复杂度从O(n)降到O(logn)
     * 时间复杂度O(log(sum(nums[i]))*V)
     * @param weight
     * @param value
     * @param nums
     * @param V
     * @return
     */
    public int maxValue5(int[] weight, int[] value, int[] nums, int V) {
        List<Integer> w = new ArrayList<>();
        List<Integer> v = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int count = nums[i];
            //1 * weight[i], 1 * value[i]
            //2 * weight[i], 2 * value[i]
            //4 * weight[i], 4 * value[i]
            for (int k = 1; k < count; k *= 2) {
                count -= k;
                w.add(weight[i] * k);
                v.add(value[i] * k);
            }
            //剩下不够2的n次方的
            if (count > 0) {
                w.add(weight[i] * count);
                v.add(value[i] * count);
            }
        }

        //01背包
        int[] dp = new int[V + 1];
        for (int i = 0; i < weight.length; i++) {
            int wi = w.get(i), vi = v.get(i);
            for (int j = V; j >= wi; j--) {
                dp[j] = Math.max(dp[j], dp[j - wi] + vi);
            }
        }
        return dp[V];
    }

}
