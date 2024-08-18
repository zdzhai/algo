package com.leetcode.jindian.string_01;

/**
 * @author dongdong
 * @Date 2024/8/1 20:00
 * 面试题01.03.URL化
 */
public class ReplaceSpaces {
    public static void main(String[] args) {
        String S = "";
        int length = 0;
        System.out.println(replaceSpaces(S, length));
    }

    /**
     * 先按照length长度把字符数组做裁剪
     * 构造一个length*3长度的字符数组charArr来存储转换后的结果
     * 使用两个指针，
     * 时间复杂度O(n)
     * @param S
     * @param length
     * @return
     */
    public static String replaceSpaces(String S, int length) {
        if ("".equals(S)) return "";
        char[] charArr = new char[length * 3];
        int j = 0;
        for (int i = 0; i < length; i++) {
            char ch = S.charAt(i);
            if (' ' == ch) {
                charArr[j++] = '%';
                charArr[j++] = '2';
                charArr[j++] = '0';
            }
            else {
                charArr[j++] = ch;
            }
        }
        return String.valueOf(charArr, 0, j);
    }
}
