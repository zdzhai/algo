package com.yugutou.charpter4_stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode 150.逆波兰表达式求值
 * @author dongdong
 * @Date 2024/1/10 20:18
 */
public class EvalRPN {
    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }

    /**
     *
     * @param tokens
     * @return
     */
    public static int evalRPN(String[] tokens) {
        Deque<Integer> numDeque = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            if (!"+".equals(tokens[i]) && !"-".equals(tokens[i])
            && !"*".equals(tokens[i]) && !"/".equals(tokens[i])) {
                numDeque.offer(Integer.parseInt(tokens[i]));
            } else {
                int  a = numDeque.removeLast();
                int  b = numDeque.removeLast();
                switch (tokens[i]) {
                    case "+":
                        numDeque.offer(a + b);
                        break;
                    case "-":
                        numDeque.offer(b - a);
                        break;
                    case "*":
                        numDeque.offer(a * b);
                        break;
                    case "/":
                        numDeque.offer(b / a);
                        break;
                }
            }
        }
        return numDeque.poll();
    }
}
