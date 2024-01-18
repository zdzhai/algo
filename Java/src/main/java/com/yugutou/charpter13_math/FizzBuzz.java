package com.yugutou.charpter13_math;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * leetcode 412. Fizz Buzz
 * @author dongdong
 * @Date 2024/1/18 22:10
 */
public class FizzBuzz {
    public static void main(String[] args) {

    }

    public static List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                answer.add("FizzBuzz");
            }
            else if (i % 3 == 0) {
                answer.add("Fizz");
            }
            else if (i % 5 == 0) {
                answer.add("Buzz");
            } else {
                answer.add(String.valueOf(i));
            }
        }
        return answer;
    }
}
