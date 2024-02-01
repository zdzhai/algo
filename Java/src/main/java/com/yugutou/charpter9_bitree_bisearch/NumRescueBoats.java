package com.yugutou.charpter9_bitree_bisearch;

import java.util.Arrays;

/**
 * leetcode 881.救生艇
 * @author dongdong
 * @Date 2024/1/30 9:40
 */
public class NumRescueBoats {
    public static void main(String[] args) {
        int[] people = {5,1,4,2};
        int limit = 6;
        NumRescueBoats numRescueBoats = new NumRescueBoats();
        System.out.println(numRescueBoats.numRescueBoats(people, limit));
        System.out.println(numRescueBoats.numRescueBoats2(people, limit));
    }

    /**
     * 最小船数k 二分
     * k取值范围在1- nums.length
     * 当前k小于需要的船只，k必须增大
     * 时间复杂度排序O(nlogn) + 二分*遍历O(nlogn)
     * 空间复杂度O(1)
     * @param people
     * @param limit
     * @return
     */
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        Arrays.sort(people);

        int l = 1, r = n;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (check(people, limit, mid)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }

    /**
     *
     * @param people
     * @param limit
     * @param k 有k条船
     * @return
     */
    private boolean check(int[] people, int limit, int k) {
        int need = 0;
        int n = people.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int weight = people[l] + people[r];
            if (weight > limit) {
                r--;
            } else {
                l++;
                r--;
            }
            need++;
        }
        return need > k;
    }

    /**
     * 直接排序后贪心遍历
     * 时间复杂度排序O(nlogn) + 遍历O(n) 和上边执行时间差不多，二分耗时短
     * 空间复杂度O(1)
     * @param people
     * @param limit
     * @return
     */
    public int numRescueBoats2(int[] people, int limit) {
        int n = people.length;
        Arrays.sort(people);
        int need = 0;
        int l = 0, r = n - 1;
        while (l <= r) {
            int weight = people[l] + people[r];
            if (weight > limit) {
                r--;
            } else {
                l++;
                r--;
            }
            need++;
        }
        return need;
    }

}
