package com.yugutou.charpter18_backtracking.level3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author dongdong
 * @Date 2023/12/19 20:15
 * leetcode17
 */
public class LetterCombinations {

    List<String> ans = new LinkedList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new LinkedList<>();
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        letterCombinationsHelper(digits, map, 0);
        return ans;
    }

    public void letterCombinationsHelper(String digits,
                                         Map<Character, String> map,
                                         int startIndex) {
        if (sb.length() == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        String str = map.get(digits.charAt(startIndex));
        for (int j = 0; j < str.length(); j++) {
            sb.append(str.charAt(j));
            letterCombinationsHelper(digits, map, startIndex + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> list = letterCombinations.letterCombinations(digits);
        System.out.println(list);
    }
}
