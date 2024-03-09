package com.yugutou.charpter3_array.union_find;


import java.util.*;

/**
 * leetcode 399. 除法求值
 * @author dongdong
 * @Date 2024/1/4 13:28
 */
public class CalcEquation {
    public static void main(String[] args) {

    }

    /**
     * 使用并查集
     *
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    public double[] calcEquation(List<List<String>> equations,
                                 double[] values,
                                 List<List<String>> queries) {

        return null;
    }
}

class Union {

    private Map<String, String> parent;

    public Union(List<List<String>> equations) {
        for (List<String> equation : equations) {
            parent.put(equation.get(0), equation.get(1));
        }
    }

    public String find(String str) {
        if (!parent.containsKey(str)) {
            return null;
        }
        while (!str.equals(parent.get(str))) {
            str = parent.get(str);
        }
        return str;
    }

    public void union(String str1, String str2) {
        String s1 = find(str1);
        String s2 = find(str2);
        if (s1.equals(s2)) {
            return;
        }
        parent.put(s1, s2);
    }
}


