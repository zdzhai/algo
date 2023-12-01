package com.yugutou.charpter9_bitree_bisearch.level2;

public class Sqrt {
    public static void main(String[] args) {
        System.out.println(sqrt(9));
    }

    /**
     * if mid * mid > x right = mid - 1;
     * else left = mid + 1
     * @param x
     * @return
     */
    public static int sqrt (int x) {
        int left = 0;
        int right = x;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
