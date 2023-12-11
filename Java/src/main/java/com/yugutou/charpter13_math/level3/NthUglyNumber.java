package com.yugutou.charpter13_math.level3;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class NthUglyNumber {
    public static void main(String[] args) {

        System.out.println(getUglyNumber(10));
        System.out.println(getUglyNumber2(10));
        System.out.println(getUglyNumber3(1407));
    }

    /**
     * 第一种方法，直接计算比较
     *
     * @param index
     * @return
     */
    public static int getUglyNumber(int index) {
        if (index <= 0) {
            return 0;
        }
        int number = 0;
        int uglyFound = 0;
        while (uglyFound < index) {
            ++number;
            if (nthUglyNumber1(number)) {
                ++uglyFound;
            }
        }
        return number;
    }

    public static boolean nthUglyNumber1(int index) {
        while (index % 2 == 0) {
            index /= 2;
        }
        while (index % 3 == 0) {
            index /= 3;
        }
        while (index % 5 == 0) {
            index /= 5;
        }
        return index == 1;
    }

    /**
     * 第二种方式，通过埃氏筛
     *
     * @param index
     * @return
     */

    public static int getUglyNumber2(int index) {
        if (index < 1)
            return 0;
        int[] pUglyNumbers = new int[index]; //依次保存第n个丑数
        pUglyNumbers[0] = 1; //第一个丑数是1
        int pMultiply2 = 0, pMultiply3 = 0, pMultiply5 = 0;

        for (int i = 1; i < index; i++) {
            int min = getMin(pUglyNumbers[pMultiply2] * 2, pUglyNumbers[pMultiply3] * 3,
                    pUglyNumbers[pMultiply5] * 5);
            pUglyNumbers[i] = min;
            while (pUglyNumbers[pMultiply2] * 2 <= min)
                pMultiply2++;
            while (pUglyNumbers[pMultiply3] * 3 <= min)
                pMultiply3++;
            while (pUglyNumbers[pMultiply5] * 5 <= min)
                pMultiply5++;
        }
        return pUglyNumbers[index - 1];
    }

    public static int getMin(int a, int b, int c) {
        int min = a > b ? b : a;
        return c < min ? c : min;
    }

    /**
     * todo 使用优先队列（对于本题优先在那里了）
     * 额外使用set做去重
     * @param index
     * @return
     */
    public static int getUglyNumber3(int index) {
        int[] nums = {2, 3, 5};
        Set<Long> set = new HashSet<>();
        Queue<Long> pq = new PriorityQueue<>();
        set.add(1L);
        pq.offer(1L);
        for (int i = 1; i <= index; i++) {
            Long x = pq.poll();
            if (i == index) {
                return x.intValue();
            }
            for (int num : nums) {
                long n = x * num;
                if (!set.contains(n)) {
                    set.add(n);
                    pq.offer(n);
                }
            }
        }
        return -1;
    }

}
