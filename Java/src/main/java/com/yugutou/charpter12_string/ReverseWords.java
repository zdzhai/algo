package com.yugutou.charpter12_string;

import java.util.Arrays;

/**
 * @author dongdong
 * @Date 2023/12/29 10:51
 */
public class ReverseWords {
    public static void main(String[] args) {
        String s = "Mr Ding";
        System.out.println(reverseWords(s));
    }

    /**
     * 每一个单词单独反转
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        int start = 0, end = 0;
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (ch == ' ') {
                reverseWord(chars, start, end - 1);
                start = end + 1;
            }
            end++;
        }
        reverseWord(chars, start, end - 1);
        return String.valueOf(chars);
    }

    public static void reverseWord(char[] chars, int start, int end) {
        while (start <= end) {
            char temp = chars[start];
            chars[start] =chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
