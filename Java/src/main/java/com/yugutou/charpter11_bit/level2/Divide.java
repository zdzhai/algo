package com.yugutou.charpter11_bit.level2;

/**
 * leetcode 29. 两数相除
 * @author dongdong
 * @Date 2024/1/5 22:40
 */
public class Divide {
    public static void main(String[] args) {
        System.out.println(divide2(Integer.MIN_VALUE, 2));
        System.out.println(Integer.toBinaryString(136));
        System.out.println(Integer.toBinaryString(-136));
    }

    /**
     * 10 / 3
     * 1010 11
     * 01111111
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = (dividend ^ divisor) < 0 ? -1 : 1;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int ans = 0;
        //5 / 2
        // 101  10
        // ans += 2
        for (int i = 31; i >= 0; i--) {
            if ((dividend >> i) >= divisor) {
                ans += (1 << i);
                dividend -= (divisor << i);
            }
        }
        if (sign < 0) {
            ans = -ans;
        }
        return ans;
    }

    public static int divide2(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = (dividend ^ divisor) < 0 ? -1 : 1;
        long a = dividend;
        long b = divisor;
        if (a < 0) a = (~a + 1);
        if (b < 0) b = (~b + 1);

        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            if ((a >> i) >= b) {
                ans += (1 << i);
                a -= (b << i);
            }
        }
        if (sign < 0) {
            ans = -ans;
        }
        return ans;
    }

    /**
     * 商的最小值是0，最大值就是dividend
     * 所以可以二分查找 mid
     * 如果dividend * mid > dividend mid必须得减小
     * 如果dividend * mid <= dividend mid增大
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide3(int dividend, int divisor) {
        long x = dividend, y = divisor;
        int sign = (x ^ y) < 0 ? 1 : -1;
        x = x < 0 ? -x : x;
        y = y < 0 ? -y : y;
        long l = 0, r = x;
        long ans = 0;
        while (l < r) {
            long mid = l + 1 + ((r - l) >> 1);
            if (mult(mid, y) > x) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        ans = sign > 0 ? l : -l;
        if (ans >  Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int)ans;
    }

    private static long mult(long mid, long y) {
        long ans = 0;
        while (y > 0) {
            if ((y & 1) == 1) {
                ans += mid;
            }
            y >>= 1;
            mid += mid;
        }
        return ans;
    }


}
