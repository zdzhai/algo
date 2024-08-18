package com.leetcode.jindian.string_01;

/**
 * @author dongdong
 * @Date 2024/8/6 10:54
 */
public class CompressString {
    public static void main(String[] args) {
        String S = "";
        System.out.println(compressString(S));
    }

    /**
     * 从头开始遍历，遇到不同的字符就重新计数
     * 最后比较源字符串和压缩后的字符长度
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * @param S
     * @return
     */
    public static String compressString(String S) {
        int n = S.length();
        if (n == 0) return "";
        StringBuilder sb = new StringBuilder();
        int i = 0, cnt;
        while (i < n) {
            char c = S.charAt(i);
            cnt = 0;
            sb.append(c);
            cnt++;
            while (++i < n && S.charAt(i) == c) {
                cnt++;
            }
            sb.append(cnt);
        }
        return S.length() > sb.toString().length() ? sb.toString() : S;
    }
}
