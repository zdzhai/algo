package com.yugutou.charpter3_array;

import java.util.Arrays;

/**
 * leetcode. 73. 矩阵置零
 * @author dongdong
 * @Date 2024/1/8 19:17
 */
public class SetZeroes {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        //setZeroes(matrix);
        //setZeroes2(matrix);
        setZeroes3(matrix);
    }

    /**
     * 构建新数组 初始化为-1，读取原数组，读取到0，
     * @param matrix
     */
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] array = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = -1;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < n; k++) {
                        array[i][k] = 0;
                    }
                    for (int k = 0; k < m; k++) {
                        array[k][j] = 0;
                    }
                } else {
                    if (array[i][j] != 0) {
                        array[i][j] = matrix[i][j];
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(array));
    }

    /**
     * 用一个一维数组，保存数组中数的状态
     * 用m个数的字符串数组，每一个数有n个bit位来表示这n个数是否为0.
     * @param matrix
     */
    public static void setZeroes2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] nums = new int[m * n];
        Arrays.fill(nums, -1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    int idx = i * n + j;
                    nums[idx] = 0;
                    for (int k = 0; k < n; k++) {
                        nums[i * n + k] = 0;
                    }
                    for (int k = 0; k < m; k++) {
                        nums[k * n + j] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = i * n + j;
                if (nums[idx] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void setZeroes3(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append("a");
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    int idx = i * n + j;
                    sb.setCharAt(idx, '0');
                    for (int k = 0; k < n; k++) {
                        sb.setCharAt(i * n + k, '0');
                    }
                    for (int k = 0; k < m; k++) {
                        sb.setCharAt(k * n + j, '0');
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = i * n + j;
                if (sb.charAt(idx) == '0') {
                    matrix[i][j] = 0;
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }
}
