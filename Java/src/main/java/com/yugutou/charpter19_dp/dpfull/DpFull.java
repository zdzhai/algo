package com.yugutou.charpter19_dp.dpfull;

/**
 * 完全背包
 * @author dongdong
 * @Date 2024/1/27 15:22
 */
public class DpFull {
    public static void main(String[] args) {

    }

    /**
     * 每个物品可以任意次放置
     * dp[i][j] 表示在前i个物品内，任意选取个数的最大价值
     * 不选i dp[i][j] = dp[i - 1][j];
     * 选1次 dp[i][j] = dp[i - 1][j - weight[i]] + value[i];
     * 选2次 dp[i][j] = dp[i - 1][j - 2 * weight[i]] + 2 * value[i];
     * 如果 j - k * weight[i] >= 0
     * 选k次 dp[i][j] = dp[i - 1][j - k * weight[i]] + k * value[i];
     * @param weight 物品重量
     * @param value  物品价值
     * @param V      背包容量
     * @return
     */
    public int maxValue(int[] weight, int[] value, int V) {
        int n = weight.length;
        int[][] dp = new int[n][V + 1];

        //只有一个物品是，往最大个数去放
        for (int j = 0; j <= V; j++) {
            int max = j / weight[0];
            dp[0][j] = max * value[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= V; j++) {
                //不选
                int res1 = dp[i - 1][j];
                int k = 1;
                int res2 = 0;
                //容量允许范围内，选1-k个得到的最大值
                while (j - k * weight[i] >= 0) {
                    res2 = Math.max(res2, dp[i - 1][j - k * weight[i]] + k * value[i]);
                    k++;
                }
                dp[i][j] = Math.max(res1, res2);
            }
        }
        return dp[n - 1][V];
    }

    /**
     * 滚动数组解法
     * @param weight
     * @param value
     * @param V
     * @return
     */
    public int maxValue2(int[] weight, int[] value, int V) {
        int n = weight.length;
        int[][] dp = new int[2][V + 1];

        //只有一个物品是，往最大个数去放
        for (int j = 0; j <= V; j++) {
            int max = j / weight[0];
            dp[0][j] = max * value[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= V; j++) {
                //不选
                int res1 = dp[(i - 1) & 1][j];
                int k = 1;
                int res2 = 0;
                //容量允许范围内，选1-k个得到的最大值
                while (j - k * weight[i] >= 0) {
                    res2 = Math.max(res2, dp[(i - 1) & 1][j - k * weight[i]] + k * value[i]);
                    k++;
                }
                dp[i & 1][j] = Math.max(res1, res2);
            }
        }
        return dp[(n - 1) & 1][V];
    }

    /**
     * 优化为一维数组
     * https://mp.weixin.qq.com/s/nke1OjkhKACaONx1opk8AA
     * 得出完全背包的递推公式为
     * dp[i][j] = max(dp[i - 1][j], dp[i][j - weight[i]] + value[i]);
     * 本行依赖的是本行上一个值以及本行前边的值，所以是从小到大更新
     * 01背包的递推公式是：
     * dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i])
     * 本行依赖的是本行上一个值以及上一行前边的值，所以是从大到小更新
     * @param weight
     * @param value
     * @param V
     * @return
     */
    public int maxValue3(int[] weight, int[] value, int V) {
        int n = weight.length;
        int[] dp = new int[V + 1];

        for (int j = 0; j <= V; j++) {
            int max = j / weight[0];
            dp[j] = max * value[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= V; j++) {
                int res1 = dp[j];
                int res2 = j >= weight[i] ? dp[j - weight[i]] + value[i] : 0;
                dp[j] = Math.max(res1, res2);
            }
        }
        return dp[V];
    }
}
