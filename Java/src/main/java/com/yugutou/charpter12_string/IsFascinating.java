package com.yugutou.charpter12_string;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 2729.判断一个数是否迷人
 * @author dongdong
 * @Date 2024/1/26 20:47
 */
public class IsFascinating {
    public static void main(String[] args) {
        System.out.println(isFascinating(999));
    }

    public static boolean isFascinating(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(n);
        sb.append(n * 2);
        sb.append(n * 3);
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (ch == '0' || set.contains(ch)) {
                return false;
            } else {
                set.add(ch);
            }
        }
        return true;
    }
}
