package com.yugutou.charpter9_bitree_bisearch;

/**
 * leetcode 29. 两数相除
 * @author dongdong
 * @Date 2024/1/5 22:40
 */
public class Divide {
    public static void main(String[] args) {
        System.out.println(divide(10,3));
        System.out.println(Integer.toBinaryString(136));
        System.out.println(Integer.toBinaryString(-136));
    }

    public static int divide(int a, int b) {
        long x = a, y = b;
        boolean isNeg = false;
        if ((x > 0 && y < 0) || (x < 0 && y > 0)) isNeg = true;
        if (x < 0) x = -x;
        if (y < 0) y = -y;
        long l = 0, r = x;
        while (l < r) {
            long mid = l + 1 + ((r - l) >> 1);
            if (mul(mid, y) > x) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        long ans = isNeg ? -l : l;
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) return Integer.MAX_VALUE;
        return (int)ans;
    }

    static long mul(long a, long k) {
        long ans = 0;
        while (k > 0) {
            if ((k & 1) == 1) {
                ans += a;
            }
            k >>= 1;
            //a 2a 4a 8a 16a
            a += a;
        }
        return ans;
    }
}
