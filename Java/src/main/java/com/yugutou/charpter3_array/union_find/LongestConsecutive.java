package com.yugutou.charpter3_array.union_find;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 128.最长连续序列
 * @author dongdong
 * @Date 2024/1/3 21:07
 */
public class LongestConsecutive {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        int i = longestConsecutive(nums);
        System.out.println(i);
    }

    public static int longestConsecutive(int[] nums) {
        UnionFind unionFind = new UnionFind(nums);
        int ans = 0;
        //更新每个元素的右边界
        for (int num : nums) {
            //看num+1是否存在，存在则设置num的右边界为num+1的右边界
            if (unionFind.find(num + 1) != null) {
                unionFind.union(num, num + 1);
            }
        }

        //看每个元素的最大有边界
        for (int num : nums) {
            Integer right = unionFind.find(num);
            ans = Math.max(ans, right - num + 1);
        }

        return ans;
    }
}

class UnionFind {
    // 记录每个节点的父节点
    private Map<Integer, Integer> parent;

    public UnionFind(int[] nums) {
        parent = new HashMap<>();
        // 初始化父节点为自身
        for (int num : nums) {
            parent.put(num, num);
        }
    }

    // 寻找x的父节点，实际上也就是x的最远连续右边界，这点类似于方法2
    //查找x的右边界
    public Integer find(int x) {
        if (!parent.containsKey(x)) {
            return null;
        }
        while (x != parent.get(x)) {
            // 进行路径压缩，不写下面这行也可以，但是时间会慢些
            parent.put(x, parent.get(parent.get(x)));
            x = parent.get(x);
        }
        return x;
    }

    // 合并两个连通分量，在本题中只用来将num并入到num+1的连续区间中
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }
        parent.put(rootX, rootY);
    }
}