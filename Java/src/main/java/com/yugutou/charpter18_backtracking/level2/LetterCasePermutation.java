package com.yugutou.charpter18_backtracking.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode784
 */
class LetterCasePermutation {
    List<String> res = new ArrayList<>();

    //主方法
    public List<String> letterCasePermutation(String s) {
        char[] cs = s.toCharArray();
        dfs(cs, 0);
        return res;
    }

    /**
     * @param cs  搜索的字符数组
     * @param startIndex 开始搜索的位置
     */
    void dfs(char[] cs, int startIndex) {
        res.add(String.valueOf(cs));
        for (int i = startIndex; i < cs.length; i++) {
            if (isDigit(cs[i])) {
                continue;
            }
            cs[i] = changeLetter(cs[i]);
            dfs(cs, i + 1);
            cs[i] = changeLetter(cs[i]);
        }
    }

    //反转大小写
    //32 =      0010 0000
    //a = 97 =  0110 0001
    //a ^= 32   0100 0001 = 65 = A
    //减32 就是把二进制的第6位变为0，加32 就是把二进制的第6位变为1
    public char changeLetter(char c) {
        return (c >= 'a' && c <= 'z') ? (char) (c - 32) : (char) (c + 32);
    }

    //判断是否是数字
    public boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        String s = "a1b2";
        LetterCasePermutation letterCasePermutation = new LetterCasePermutation();
        System.out.println(letterCasePermutation.letterCasePermutation(s));
    }
}
