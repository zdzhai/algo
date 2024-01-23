package com.yugutou.charpter19_dp;

/**
 * leetcode 304.二维区域和检索-矩阵不可变（二维前缀和）
 */
class NumMatrix {

    int[][] preNum;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        preNum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                preNum[i + 1][j + 1] = preNum[i + 1][j]
                        + preNum[i][j + 1] - preNum[i][j] + matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preNum[row2 + 1][col2 + 1] - preNum[row2 + 1][col1]
                - preNum[row1][col2 + 1] + preNum[row1][col1];
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3,0,1,4,2},
                {5,6,3,2,1},
                {1,2,0,1,5},
                {4,1,0,1,7},
                {1,0,3,0,5},
        };
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(1,1, 2,2));
    }
}