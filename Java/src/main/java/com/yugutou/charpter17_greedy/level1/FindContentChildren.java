package com.yugutou.charpter17_greedy.level1;

import java.util.Arrays;

/**
 * LeetCode455 分发饼干
 */
public class FindContentChildren {
    public static void main(String[] args) {
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        System.out.println(findContentChildren(g,s));
    }

    /**
     * g 胃口
     * s 饼干尺寸
     * @param g
     * @param s
     * @return
     */
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int start = s.length - 1;
        // 遍历孩子的胃口
        for (int i = g.length - 1; i >= 0; i--) {
            if (start >= 0 && s[start] >= g[i]) {
                start--;
                count++;
            }
        }
        return count;
    }

}
