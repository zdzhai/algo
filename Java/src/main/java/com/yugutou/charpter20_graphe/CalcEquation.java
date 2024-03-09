package com.yugutou.charpter20_graphe;


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
     * 带权有向图
     * 先判断两个量是否是联通的
     * 如果非连通，结果为-1，
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    public double[] calcEquation(List<List<String>> equations,
                                 double[] values,
                                 List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        int n = equations.size();
        for (int i = 0; i < n; i++) {
            String s = equations.get(i).get(0);
            String e = equations.get(i).get(1);
            double val = values[i];
            if (!map.containsKey(s)) {
                map.put(s, new HashMap<>());
            }
            if (!map.containsKey(e)) {
                map.put(e, new HashMap<>());
            }
            map.get(s).put(e, val);
            map.get(e).put(s, 1.0 / val);
            map.get(s).put(s, 1.0);
            map.get(e).put(e, 1.0);
        }
        Queue<NodeData> queue = new LinkedList<>();
        int m = queries.size();
        double[] ans = new double[m];
        Arrays.fill(ans, -1.0);
        Set<String> visited;
        for (int i = 0; i < m; i++) {
            String s = queries.get(i).get(0), e = queries.get(i).get(1);
            if (!map.containsKey(s) || !map.containsKey(e)) continue;
            queue.add(new NodeData(s, 1.0));
            visited = new HashSet<>();
            visited.add(s);
            while (!queue.isEmpty()) {
                NodeData node = queue.poll();
                Map<String, Double> nodeMap = map.get(node.key);
                for (Map.Entry<String, Double> entry : nodeMap.entrySet()) {
                    String key = entry.getKey();
                    Double weight = entry.getValue();
                    if (e.equals(key)) {
                        ans[i] = node.weight * weight;
                    }
                    if (!visited.contains(key)) {
                        visited.add(key);
                        queue.add(new NodeData(key, node.weight * weight));
                    }
                }
            }
        }
        return ans;
    }
}

class NodeData {
    String key;
    double weight;

    public NodeData(String key, double weight) {
        this.key = key;
        this.weight = weight;
    }
}


