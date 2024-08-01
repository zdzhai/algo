package com.leetcode.jindian;

import java.util.Arrays;

/**
 * @author dongdong
 * @Date 2024/7/31 10:00
 * 面试题01.02.判定是否互为字符重排
 */
public class CheckPermutation {
    public static void main(String[] args) {

        String s1 = "abc";
        String s2 = "bad";
        System.out.println(checkPermutation(s1, s2));
    }

    /**
     * 思路1：先遍历s1放入数组++，再遍历s2，数组--，最后出现非零的就false
     * 思路2：直接从小到大排序，然后equals
     * Arrays.sort()是使用归并排序，时间复杂度为O(n*logn)
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkPermutation(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        Arrays.sort(chars1);
        s1 = String.valueOf(chars1);

        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars2);
        s2 = String.valueOf(chars2);

        return s1.equals(s2);
    }
}
