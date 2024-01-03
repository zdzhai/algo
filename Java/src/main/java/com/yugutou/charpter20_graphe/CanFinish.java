package com.yugutou.charpter20_graphe;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 207. 课程表
 * @author dongdong
 * @Date 2024/1/2 21:16
 */
public class CanFinish {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
        System.out.println(canFinish(numCourses, prerequisites));
    }

    /**
     * 建立邻接表，表示每一个节点的出度节点
     * flag标记数组
     * 1为当前轮dfs已经访问     再次访问表示成环
     * 0为该节点未被访问
     * -1为该节点被其他轮dfs访问过
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        //建立邻接表
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>(i));
        }
        int[] flag = new int[numCourses];
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
        }
        for (int i = 0; i < adj.size(); i++) {
            if (!dfs(adj, i, flag)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(List<List<Integer>> adj, int startIndex, int[] flag) {
        if (flag[startIndex] == 1) {
            return false;
        }
        if (flag[startIndex] == -1) {
            return true;
        }
        flag[startIndex] = 1;
        for (int i = 0; i < adj.get(startIndex).size(); i++) {
            if(!dfs(adj, adj.get(startIndex).get(i), flag)) {
                return false;
            }
        }
        flag[startIndex] = -1;
        return true;
    }

}
