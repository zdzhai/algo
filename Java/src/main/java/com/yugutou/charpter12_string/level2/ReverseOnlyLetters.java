package com.yugutou.charpter12_string.level2;

import java.util.Stack;

public class ReverseOnlyLetters {
    public static void main(String[] args) {
        String s = "Test1ng-Leet=code-Q!";
        System.out.println(reverseOnlyLetters(s));
    }

    public static String reverseOnlyLetters(String S) {
        Stack<Character> letters = new Stack();
        char[] chars = S.toCharArray();
        for (char ch : chars) {
            if (Character.isLetter(ch)) {
                letters.push(ch);
            }
        }

        StringBuilder ans = new StringBuilder();
        for (char ch : chars) {
            if (Character.isLetter(ch)) {
                ans.append(letters.pop());
            } else {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}
