package com.yugutou.charpter14_heap.level2;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * leetcode 378. 有序矩阵中第K小的元素
 * @author dongdong
 * @Date 2024/1/17 22:51
 */
public class KthSmallest {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,5,9},
                {10,11,13},
                {12,13,15}
        };
        System.out.println(kthSmallest( matrix, 8));
        System.out.println(kthSmallest2( matrix, 8));

    }

    /**
     * 使用优先队列
     * 最大堆 初始化为k个元素，填满后，把peek丢掉
     * @param matrix
     * @param k
     * @return
     */
    public static int kthSmallest(int[][] matrix, int k) {
        Queue<Integer> pq = new PriorityQueue<>(k, (a,b) -> b -a);
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pq.offer(matrix[i][j]);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }

        return pq.peek();
    }

    /**
     * 使用二分查找
     * 如果小于等于min的数小于k了，说明mid太小，要放大
     * @param matrix
     * @param k
     * @return
     */
    public static int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;
        int l = matrix[0][0];
        int r = matrix[n - 1][n - 1];
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (check(matrix, mid, k, n)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private static boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1, j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += (i + 1);
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }

}
