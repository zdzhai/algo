package com.yugutou.charpter13_math.level2;

/**
 * @author dongdong
 * @Date 2023/12/9 21:04
 */
public class Pow {
    public static void main(String[] args) {
        System.out.println(myPow(2.1, 3));
        System.out.println(myPow2(2, -2));
    }

    public static double myPow(double x, int n) {
        double ans = 1.0;
        if (n == 0) {
            return ans;
        }
        if (n > 0) {
            while (n > 0) {
                ans *= x;
                n--;
            }
        } else {
            while (n < 0) {
                ans /= x;
                n++;
            }
        }
        return ans;
    }

    /**
     * 使用快速幂法
     * 一个数可以分解为1b1 + 2b2 + 4b3 + 8b4这种形式
     * 1 2 3 4为该数的二进制位的幂，b1 b2 b3 b4为该数的二进制位。
     * @param x
     * @param n
     * @return
     */
    public static double myPow2(double x, int n) {
        double ans = 1.0;
        if (n == 0) {
            return ans;
        }
        long b = n;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                ans *= x;
            }
            x *= x;
            b >>= 1;
        }
        return ans;
    }
}
