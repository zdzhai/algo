package com.leetcode.jindian.string_01;

/**
 * @author dongdong
 * @Date 2024/8/2 10:56
 * 面试题01.05.一次编辑
 */
public class OneEditAway {
    public static void main(String[] args) {
        String first = "pales";
        String second = "pal";
        System.out.println(oneEditAway(first, second));
        System.out.println(oneEditAway2(first, second));
    }

    /**
     * 插入一个英文字符、删除一个英文字符或者替换一个英文字符
     * 动态规划
     * dp[i][j]表示字符串first的前i位转变为 second的前j位的最小操作数
     * if ch1[i] == ch2[j] dp[i][j] = dp[i - 1][j - 1];
     * if ch1[i] != ch2[j]
     * dp[i - 1][j - 1] 替换j  fabe febe
     * dp[i][j - 1]     删除j  fabe fabbe
     * dp[i - 1][j]     插入j  fabe fae
     * 以上三个操作的最小操作数 + 1
     * 时间复杂度O(m*n)
     * @param first
     * @param second
     * @return
     */
    public static boolean oneEditAway(String first, String second) {
        int m = first.length();
        int n = second.length();

        first = " " + first;
        second = " " + second;

        char[] ch1 = first.toCharArray();
        char[] ch2 = second.toCharArray();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (ch1[i] == ch2[j]) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(dp[i - 1][j - 1],
                        Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            }
        }

        return dp[m][n] <= 1;
    }

    /**
     * 先比较长度 相差大于1 直接false
     * 然后两个指针从头遍历，记录每个字符及其索引放入map
     * 遍历较短的字符串map，比较其在长字符串map中的索引，索引绝对值大于1就直接false
     * 遍历完后
     * 存在问题：会存在一样的字符出现在不同的位置，所以需要记录相同字符出现的不同位置索引
     *
     * 一般双字符串的问题，都最好先固定好字符串长度顺序，省去多个判断
     *
     * 先比较长度 相差大于1 直接false
     * i j双指针依次遍历比较字符，
     * 相同 同时后移
     * 不同：若总长度相同，则同时后移 cnt++    替换操作
     *      若总长度不同，长字符串后移 cnt++   删除/插入操作
     * 时间复杂度O(m+n)
     * 空间复杂度O(1)
     */
    public static boolean oneEditAway2(String first, String second) {
        int m = first.length(), n = second.length();
        if (Math.abs(n - m) > 1) return false;
        if (m > n) return oneEditAway2(second, first);
        int i = 0, j = 0, cnt = 0;
        while (i < m && j < n && cnt < 2) {
            char c1 = first.charAt(i),  c2 = second.charAt(j);
            if (c1 == c2) {
                i++;
                j++;
            }
            else {
                //字符串长度相同，遇到不同字符，同时向后移动并增加cnt
                if (n == m) {
                    i++;
                    j++;
                    cnt++;
                } else {
                    //字符串长度不同，遇到不同字符，长字符串向后移动，代表向短字符串中插入
                    j++;
                    cnt++;
                }
            }
        }
        return cnt <= 1;
    }
}
