package com.yugutou.charpter13_math.level2;

public class IsPowerOfTwo {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo2(16));
    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        }
       if (n % 2 != 0) {
           return false;
       }
       while (n % 2 == 0) {
           n = n / 2;
       }
       return n == 1;
    }

    //10 1000 10000 2的幂的二进制都是起始为1，其他位为0
    public static boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
