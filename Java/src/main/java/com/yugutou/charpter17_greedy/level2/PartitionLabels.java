package com.yugutou.charpter17_greedy.level2;

import java.util.LinkedList;
import java.util.List;

public class PartitionLabels {
    public static void main(String[] args) {
        String s = "ababcbzacadefegdehijhklij";
        List<Integer> list = partitionLabels(s);
        System.out.println(list);
    }

    public static List<Integer> partitionLabels(String S) {
        List<Integer> list = new LinkedList<>();
        char[] chars = S.toCharArray();
        int[] edges = new int[26];
        for (int i = 0; i < chars.length; i++){
            edges[chars[i] - 'a'] = i;
        }
        int index = 0, pre = -1;
        for (int i = 0; i < chars.length; i++) {
            index = Math.max(index, edges[chars[i] - 'a']);
            if (i == index) {
                list.add(i - pre);
                pre = i;
            }
        }
        return list;
    }
}
