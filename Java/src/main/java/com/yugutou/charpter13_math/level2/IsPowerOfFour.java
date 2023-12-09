package com.yugutou.charpter13_math.level2;

public class IsPowerOfFour {
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
        System.out.println(isPowerOfFour2(8));
    }

    public static boolean isPowerOfFour(int n) {
        if (n <= 0)
            return false;
        while (n % 4 == 0)
            n /= 4;
        return n == 1;
    }


    public static boolean isPowerOfFour2(int n) {
        if (n <= 0) {
            return false;
        }
        int m = (int) Math.sqrt(n);
        return m * m == n && (n & (n - 1)) == 0;
    }
}
