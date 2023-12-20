package com.yugutou.charpter18_backtracking.level3;

import java.util.LinkedList;
import java.util.List;

/**
 * @author dongdong
 * @Date 2023/12/19 20:47
 * leetcode22
 */
public class GenerateParenthesis {

    List<String> ans = new LinkedList<>();
    StringBuilder sb = new StringBuilder();


    public List<String> generateParenthesis(int n) {
        generateParenthesisHelper(n, 0, 0);
        return ans;
    }

    /**
     * 左括号个数小于n，就可以添加左括号
     * 右括号个数必须小于左括号个数才可以添加右括号
     * ()
     * @param n
     */
    public void generateParenthesisHelper(int n, int leftNum, int rightNum) {
        if (rightNum == n) {
            ans.add(sb.toString());
        }
        if (leftNum < n) {
            sb.append("(");
            generateParenthesisHelper(n, leftNum + 1, rightNum);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (rightNum < leftNum) {
            sb.append(")");
            generateParenthesisHelper(n, leftNum, rightNum + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> list = generateParenthesis.generateParenthesis(3);
        System.out.println(list);
    }
}
