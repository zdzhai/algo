package com.yugutou.charpter13_math.level3;

import java.util.Arrays;

public class CountPrimes {

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
        System.out.println(countPrimes2(499979));
    }

    /**
     * 方法1：一个个的算是不是素数
     *
     * @param n
     * @return
     */
    public static int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isPrime(int num) {
        int max = (int) Math.sqrt(num);
        for (int i = 2; i <= max; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 方法2：埃氏筛
     * 如果一个数x是素数，那么2x,3x,4x一定不是素数
     */

    public static int countPrimes2(int n) {
        int[] nums = new int[n];
        Arrays.fill(nums,1);
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] == 1) {
                count++;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        nums[j] = 0;
                    }
                }
            }
        }
        return count;
    }
}
