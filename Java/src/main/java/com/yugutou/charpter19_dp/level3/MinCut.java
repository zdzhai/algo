package com.yugutou.charpter19_dp.level3;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author dongdong
 * @Date 2023/12/23 19:25
 */
public class MinCut {
    public static void main(String[] args) {
        String s = "aaaa";
        System.out.println(minCut2(s));
    }

    /**
     * 每个回文串尽可能长
     * dp[]表示长度为i的字符串被划分为回文串的最小个数
     * dp[i] =  0-j的最小个数+1，但条件是i-j是回文串
     * @param s
     * @return
     */
    public static int minCut(String s) {
        int n = s.length();
        if (n == 1) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {

            }
        }
        return 0;
    }

    /**
     * dfs可以找出能分的多少种，寻出长度最短的那个，但应该会超时
     * @param s
     * @return
     */
    public static int minCut2(String s) {
        dfs(s, 0);
        return 0;
    }

    static List<List<String>> ans = new LinkedList<>();
    static List<String> list = new LinkedList<>();

    public static void dfs(String s, int startIndex) {
        if (startIndex >= s.length()) {
            ans.add(new LinkedList<>(list));
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                list.add(s.substring(startIndex, i + 1));
            } else {
                continue;
            }
            dfs(s, i + 1);
            list.remove(list.size() - 1);
        }
    }

    //判断是否是回文串
    public static boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
