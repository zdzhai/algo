package com.yugutou.charpter19_dp.level2.yanghui;

import java.util.LinkedList;
import java.util.List;

/**
 * 根据定义实现的基本的杨辉三角
 */
public class YanghuiBasic {
    public static void main(String args[]) {
        YanghuiBasic yanghuiBasic = new YanghuiBasic();
        List<List<Integer>> generate = yanghuiBasic.generate(1);
        System.out.println(generate);
    }

    public List<List<Integer>> generate(int numRows) {
        //确定一个有10个数组（元素为数组）的二维数组
        int a[][] = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            a[i][0] = 1;
            a[i][i] = 1;
        }

        /**
         * j < i dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
         */
        for (int i = 2; i < a.length; i++) {
            for (int j = 1; j < i; j++) {
                a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
            }
        }
        List<List<Integer>> ans = new LinkedList<>();
        for (int i = 0; i < a.length; i++) {
            List<Integer> temp = new LinkedList<>();
            for (int j = 0; j <= i; j++) {
                temp.add(a[i][j]);
            }
            ans.add(temp);
        }
        return ans;
    }
}
