package com.leetcode.jindian;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dongdong
 * @Date 2024/7/31 9:34
 * 面试题01.01.判定字符是否唯一
 */
public class IsUnique {
    public static void main(String[] args) {
        String str = "leetcode";
        System.out.println(isUnique(str));
        System.out.println(isUnique2(str));
    }

    /**
     * 使用Set，遍历，存在就return 不存在就添加
     * 省空间可以使用数组
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * @param str
     * @return
     */
    public static boolean isUnique(String str) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    /**
     * ch - 'a'
     * @param str
     * @return
     */
    public static boolean isUnique2(String str) {
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (arr[ch - 'a'] > 0) {
                return false;
            }
            arr[ch - 'a']++;
        }
        return true;
    }
}
