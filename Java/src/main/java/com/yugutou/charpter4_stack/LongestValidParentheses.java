package com.yugutou.charpter4_stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author dongdong
 * @Date 2024/3/9 20:11
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        String s = "))))((()((";
        System.out.println(longestValidParentheses.longestValidParentheses(s));
    }

    /**
     * 使用栈
     * 左括号进栈，右括号出栈
     * 如果是右括号时，栈为空，则遍历下一个
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * )((((
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int n = s.length();
        if (n <= 1) return 0;
        char[] chars = s.toCharArray();
        Deque<Integer> deque = new LinkedList<>();
        int ans = 0;
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (deque.isEmpty() && ch == ')') {
                start = i + 1;
                continue;
            }
            if (ch == '(') deque.push(i);
            else {
                deque.pop();
                if (deque.isEmpty()) {
                    ans = Math.max(ans, i - start + 1);
                } else {
                    ans = Math.max(ans, i - deque.peek());
                }
            }
        }
        return ans;
    }
}
