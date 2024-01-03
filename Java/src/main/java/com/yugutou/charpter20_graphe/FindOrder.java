package com.yugutou.charpter20_graphe;

import java.util.*;

/**
 * leetcode 210. 课程表2
 * @author dongdong
 * @Date 2024/1/3 12:32
 */
public class FindOrder {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1,0}, {2,0},{3,1},{3,2}};
        System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));
    }

    /**
     * 记录出度的邻接表为0的是最后一个
     * 使用栈来反向记录走过的节点
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] flag = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>(i));
        }
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] ans = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adj, i, flag, deque)) return new int[0];
        }
        for (int i = 0; i < numCourses; i++) {
            ans[i] = deque.removeFirst();
        }
        return ans;
    }

    private static boolean dfs(List<List<Integer>> adj,
                               int i,
                               int[] flag,
                               Deque<Integer> deque) {
        if (flag[i] == 1) return false;
        if (flag[i] == -1) return true;
        flag[i] = 1;
        for (int j = 0; j < adj.get(i).size(); j++) {
            if (!dfs(adj, adj.get(i).get(j), flag, deque)) return false;
        }
        flag[i] = -1;
        deque.offerFirst(i);
        return true;
    }
}
