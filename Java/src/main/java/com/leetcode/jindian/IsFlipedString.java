package com.leetcode.jindian;

/**
 * @author dongdong
 * @Date 2024/8/8 10:21
 * 面试题01.09.字符串轮转
 */
public class IsFlipedString {
    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        System.out.println(isFlipedString(s1, s2));
        System.out.println(isFlipedString2(s1, s2));
        System.out.println(isFlipedString3(s1, s2));
    }

    /**
     * 首先判断其长度是否一致，不一致直接false 都为0是true
     * waterbottle 原始 0 1 2 3 4 5 6 7 8 9 10
     * erbottlewat 后来 3 4 5 6 7 8 9 10 0 1 2
     * abcd 0 1 2 3
     * cdab 2 3 0 1
     * abcde 0 1 2 3 4
     * bcdea 1 2 3 4 0 最大的差值为1
     * cdeab 2 3 4 0 1 最大的差值为2
     * 看字符s1中每个在s2中的索引
     * 遇到重复的如何解决？
     *
     * abcd
     * cdab cdabcdab
     * cdba cdbacdba
     * 本质是能够分割字符串，左右xy=s1,yx=s2
     * 时间复杂度O(n)
     * @param s1
     * @param s2
     * @return
     */
    public static boolean isFlipedString(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        //长度不等为false
        if (l1 != l2) return false;
        if (l1 == 0) return true;
        for (int i = 0; i < l1; i++) {
            String sub1 = s1.substring(0, i);
            String sub2 = s1.substring(i);
            if ((sub2 + sub1).equals(s2)) return true;
        }
        return false;
    }

    /**
     * erbottlewat
     * erbottlewaterbottlewat
     * xy yx
     * y xy x就会出现xy
     * 时间复杂度O(2n)=O(n) 但是字符串比较仍然非常耗时
     * @param s1
     * @param s2
     * @return
     */
    public static boolean isFlipedString2(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        //长度不等为false
        if (l1 != l2) return false;
        if (l1 == 0) return true;
        String temp = s2 + s2;
        for (int i = 0; i < l1; i++) {
            String sub = temp.substring(i, i + l1);
            if (sub.equals(s1)) return true;
        }
        return false;
    }

    /**
     * 使用字符串哈希，缩短字符串比较的耗时
     * 先得到s2的哈希值，再 s1 = s1 + s1;
     * 遍历求s1长度字符的哈希值
     * @param s1
     * @param s2
     * @return
     */
    static int N = 200010, P = 13131;
    static int[] hash = new int[N], p = new int[N];
    public static boolean isFlipedString3(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        hash[0] = 0;
        p[0] = 1;
        int n = s1.length();
        for (int i = 1; i <= n; i++) {
            hash[i] = hash[i - 1] * P + (s2.charAt(i - 1));
        }
        int t = hash[n];

        s1 = s1 + s1;
        for (int i = 1; i <= 2 * n; i++) {
            hash[i] = hash[i - 1] * P + (s1.charAt(i - 1));
            p[i] = p[i - 1] * P;
        }

        //sl...sr的hash为res = hash[r]-hash[l-1] * Base的(r-l+1)次方
        for (int i = 1; i + n - 1 <= 2 * n; i++) {
            int j = i + n - 1, cur = hash[j] - hash[i - 1] * p[j - i + 1];
            if (cur == t) return true;
        }
        return false;
    }
}
