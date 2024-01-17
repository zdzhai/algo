package com.yugutou.charpter13_math;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode. 202.快乐数
 * @author dongdong
 * @Date 2024/1/14 20:35
 */
public class IsHappy {
    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }

    public static boolean isHappy(int n) {
        if (n == 1) return true;
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            int temp = 0;
            if (set.contains(n)) return false;
            set.add(n);
            while (n > 0) {
                int last = n % 10;
                temp += last * last;
                n = (n - last) / 10;
            }
            n = temp;
        }
        return true;
    }
}
