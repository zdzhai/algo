package com.yugutou.charpter16_slide;

import java.util.*;

/**
 * leetcode 187.重复的DNA序列
 * @author dongdong
 * @Date 2024/1/30 20:47
 */
public class FindRepeatedDnaSequences {
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        FindRepeatedDnaSequences findRepeatedDnaSequences = new FindRepeatedDnaSequences();
        System.out.println(findRepeatedDnaSequences.findRepeatedDnaSequences(s));
        System.out.println(findRepeatedDnaSequences.findRepeatedDnaSequences2(s));
    }

    /**
     * 长度给定，直接滑动窗口
     * 时间复杂度O(n * C)
     * 空间复杂度
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        if (n < 10) return new ArrayList<>();
        int l = 0, r = 10;
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        while (r <= n) {
            String sub = s.substring(l, r);
            int num = map.getOrDefault(sub, 0);
            if (num == 1) {
                list.add(sub);
            }
            map.put(sub, num + 1);
            l++;
            r++;
        }
        return list;
    }

    /**
     * 字符串哈希
     * String的hashcode()源码就是这么实现的
     * 使用前缀和+哈希表
     * @param s
     * @return
     */
    int N = (int) 1e5 + 10, P = 131313;
    public List<String> findRepeatedDnaSequences2(String s) {
        int[] h = new int[N];
        int[] p = new int[N];
        int n = s.length();

        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            h[i] = h[i - 1] * P + s.charAt(i - 1);
            p[i] = p[i - 1] * P;
        }

        List<String> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i + 10 - 1 <= n; i++) {
            int j = i + 10 - 1;
            int hash = h[j] - h[i - 1] * p[j - i + 1];
            int count = map.getOrDefault(hash, 0);
            if (count == 1) list.add(s.substring(i - 1, j));
            map.put(hash, count + 1);
        }
        return list;
    }
}
