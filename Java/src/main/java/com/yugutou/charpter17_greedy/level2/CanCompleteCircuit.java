package com.yugutou.charpter17_greedy.level2;

/**
 * @author dongdong
 * @Date 2023/12/15 21:25
 */
public class CanCompleteCircuit {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int ans = canCompleteCircuit(gas, cost);
        System.out.println(ans);
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totNum = 0;
        int curNum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            curNum += gas[i] - cost[i];
            totNum += gas[i] - cost[i];
            if (curNum < 0) {
                curNum = 0;
                start = i + 1;
            }
        }
        if (totNum < 0) {
            return -1;
        }
        return start;
    }
}
