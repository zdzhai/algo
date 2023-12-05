package com.yugutou.charpter12_string.level2;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        System.out.println(Arrays.toString(s));

    }

    public static void reverseString(char[] s) {
        int n = s.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
}
