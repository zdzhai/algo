package com.yugutou.charpter3_array;

import java.util.LinkedList;
import java.util.List;

/**
 * @author dongdong
 * @Date 2023/12/29 9:07
 */
public class SpiralOrder {
    public static void main(String[] args) {
        int[][] matrix = {{2,5,8},{4,0,-1}};
        System.out.println(spiralOrder(matrix));
    }

    /**
     * m行n列
     *
     * m= 0,n(0,n-1)
     * n= n-1, m(1,m-1)
     * m= m-1,n = (n-2,0)
     * n=0,m(m-1,1)
     *
     * m=1,n=(1,n-2)
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ans = new LinkedList<>();
        int k = 0;
        int t = 0, b = m - 1, l = 0, r = n - 1;
        while (true) {
            for (int i = l; i <= r; i++) {
                ans.add(matrix[t][i]);
            }
            if (++t > b) break;
            for (int i = t; i <= b; i++) {
                ans.add(matrix[i][r]);
            }
            if (--r < l) break;
            for (int i = r; i >= l; i--) {
                ans.add(matrix[b][i]);
            }
            if (--b < t) break;
            for (int i = b; i >= t ; i--) {
                ans.add(matrix[i][l]);
            }
            if (++l > r) break;
        }
        return ans;
    }
}
