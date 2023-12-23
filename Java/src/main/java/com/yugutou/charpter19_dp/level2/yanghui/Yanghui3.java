package com.yugutou.charpter19_dp.level2.yanghui;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 一个数组实现
 */
public class Yanghui3 {
    public static List<Integer> generate(int rowIndex) {
        List<Integer> pre = new LinkedList<>();
        pre.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                if (j == i) {
                    pre.add(1);
                } else {
                    pre.set(j, pre.get(j) + pre.get(j - 1));
                }
            }
        }
        return pre;
    }

    public static void main(String[] args) {
        List<Integer> yanghui = generate(1);
        for (int i = 0; i < yanghui.size(); i++) {
            System.out.print(yanghui.get(i) + " ");
        }
    }
}
