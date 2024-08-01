package com.leetcode.jindian;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dongdong
 * @Date 2024/8/1 20:14
 * 面试题01.04.回文排列
 */
public class CanPermutePalindrome {
    public static void main(String[] args) {

        String s = "";
        System.out.println(canPermutePalindrome(s));
        System.out.println(canPermutePalindrome2(s));

    }


    /**
     * 核心就是奇数个的字符只能有1或0个
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * 注意：题目中没有提到字符的大小写以及是否只有英文字母
     * 以及字符串的长度
     * 使用哈希表 不用实际记录某个字符的个数
     * @param s
     * @return
     */
    public static boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!set.contains(ch)) {
                set.add(ch);
            } else {
                set.remove(ch);
            }
        }
        if (set.size() > 1) {
            return false;
        }
        return true;
    }

    /**
     * 核心就是奇数个的字符只能有1或0个
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * 注意：题目中没有提到字符的大小写以及是否只有英文字母
     * 以及字符串的长度
     *
     * 进阶：偶数个相消，很容易想到位运算
     * 英文字符共有128个，可以使用位运算记录字符出现的次数
     * 一个long类型能够表示64位，也就是64个字符，所以使用两个long类型就可以
     * @param s
     * @return
     */
    public static boolean canPermutePalindrome2(String s) {
        long highBit = 0L, lowBit = 0L;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 64) {
                highBit ^= 1L << ch - 64;
            } else {
                lowBit ^= 1L << ch;
            }
        }
        return Long.bitCount(highBit) + Long.bitCount(lowBit) <= 1;
    }
}
