package com.yugutou.charpter3_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dongdong
 * @Date 2023/12/29 10:35
 */
public class GenerateMatrix {
    public static void main(String[] args) {
        int[][] matrix = generateMatrix(10);
        for (int[] array : matrix) {
            System.out.println(Arrays.toString(array));
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int t = 0, b = n - 1, l = 0, r = n - 1;
        int num = 1;
        while (true) {
            for (int i = l; i <= r; i++) {
                ans[t][i] = num++;
            }
            if (++t > b) break;
            for (int i = t; i <= b; i++) {
                ans[i][r] = num++;
            }
            if (--r < l) break;
            for (int i = r; i >= l; i--) {
                ans[b][i] = num++;
            }
            if (--b < t) break;
            for (int i = b; i >= t; i--) {
                ans[i][l] = num++;
            }
            if (++l > r) break;
        }
        return ans;
    }
}
