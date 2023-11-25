package com.yugutou.charpter4_stack.level2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IsValid {

    static boolean isValid(String s) {
        if (s.length() <= 1) {
            return false;
        }
        Map<Character, Character> smap = new HashMap<>();
        smap.put('(', ')');
        smap.put('{', '}');
        smap.put('[', ']');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(smap.get(ch));
            } else if (stack.isEmpty() || stack.pop() != ch) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = ")[]{}";
        System.out.println(isValid(s));
    }
}
