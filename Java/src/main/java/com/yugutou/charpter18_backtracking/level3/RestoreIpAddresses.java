package com.yugutou.charpter18_backtracking.level3;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode93
 */
public class RestoreIpAddresses {

    List<String> result = new ArrayList<>();
    // 用来存放符合条件结果
    Deque<String> deque = new LinkedList<>();


    public List<String> restoreIpAddresses(String s) {
        //这个是IP的特性决定的
        if (s.length() < 4 || s.length() > 12)
            return result;
        backTrack(s, 0, 0);
        return result;
    }

    // startIndex: 搜索的起始位置， pointNum:添加小数点的数量
    private void backTrack(String s, int startIndex, int pointNum) {
        if (pointNum == 3) {
            if (isValid(s, startIndex, s.length() - 1)) {
                deque.offerLast(s.substring(startIndex));
                result.add(convertDequeToString(deque));
                deque.removeLast();
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s, startIndex, i)) {
                deque.offerLast(s.substring( startIndex, i + 1));
                backTrack(s, i + 1, pointNum + 1);
                deque.removeLast();
            } else {
                break;
            }
        }
    }

    private String convertDequeToString(Deque<String> deque) {
        String ans = "";
        for (String str : deque) {
            ans += str;
            ans += ".";
        }
        return ans.substring(0, ans.length() - 1);
    }

    // 判断字符串s在左闭⼜闭区间[start, end]所组成的数字是否合法
    private Boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        // 0开头的数字不合法
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            // 遇到⾮数字字符不合法
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) { // 如果⼤于255了不合法
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "25525511135";

        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        List<String> list = restoreIpAddresses.restoreIpAddresses(s);
        System.out.println(list);
    }
}
