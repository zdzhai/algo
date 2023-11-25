package com.yugutou.charpter4_stack.level3;

import java.util.*;

public class Calculate {
    public static int calculate(String s) {
        Deque<Integer> numStack = new LinkedList<>();
        Set<Character> set = new HashSet<>();
        set.add('+');
        set.add('-');
        set.add('*');
        set.add('/');
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            String str = "";
            int j = i;
            while (j < s.length() && !set.contains(s.charAt(j))) {
                if (s.charAt(j) == ' ') {
                    j++;
                    continue;
                }
                str += s.charAt(j);
                j++;
            }
            int num = Integer.valueOf(str);
            switch (sign) {
                case '+':
                    numStack.push(num);
                    break;
                case '-':
                    numStack.push(num * -1);
                    break;
                case '*':
                    numStack.push(numStack.pop() * num);
                    break;
                case '/':
                    numStack.push(numStack.pop() / num);
                    break;
            }
            if (j < s.length()) {
                sign = s.charAt(j);
            }
            i = j;
        }
        int ans = 0;
        while (!numStack.isEmpty()) {
            ans += numStack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(calculate( "0-123"));
    }
}
