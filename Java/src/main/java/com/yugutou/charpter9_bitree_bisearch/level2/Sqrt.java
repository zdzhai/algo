package com.yugutou.charpter9_bitree_bisearch.level2;

/**
 * leetcode 69.x的平方根
 */
public class Sqrt {
    public static void main(String[] args) {
        System.out.println(sqrt(2147483647));
        System.out.println(mySqrt(2147483647));
    }

    /**
     * if mid * mid > x right = mid - 1;
     * else left = mid + 1
     * @param x
     * @return
     */
    public static int sqrt (int x) {
        int left = 0, right = x, ans = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if ((long) mid * mid > x) {
                right = mid - 1;
            } else {
                ans = mid;
                left = mid + 1;
            }
        }
        return ans;
    }

    public static int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 0, right = x;
        while (left < right) {
            int mid = left + 1 + ((right - left) >> 1);
            if ( (long) mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
