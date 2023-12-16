package com.yugutou.charpter17_greedy.level2;

import java.util.Arrays;
import java.util.Comparator;

public class CanAttendMeetings {
    public static void main(String[] args) {

        int[][] intervals = {{0, 30}, {15, 20}, {5, 10}};
        System.out.println(canAttendMeetings(intervals));


    }

    public static boolean canAttendMeetings(int[][] intervals) {
        //按照会议开始时间排序
        Arrays.sort(intervals, (a, b) ->  a[0] - b[0]);
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i + 1][0] <= intervals[i][1]) {
                return false;
            }
        }
        return true;
    }
}
