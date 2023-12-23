package com.yugutou.charpter19_dp.level2.yanghui;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 滚动数组优化
 */
public class Yanghui2 {

    public static void main(String[] args) {
        List<Integer> list = getRow(0);
        System.out.println(list);
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new LinkedList<>();
        pre.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> cur = new LinkedList<>();
            //1,1
            cur.add(1);
            for (int j = 1; j < i; j++) {
                cur.add(pre.get(j - 1) + pre.get(j));
            }
            cur.add(1);
            pre = cur;
        }
        return pre;
    }
}
