package com.yugutou.charpter9_bitree_bisearch;

/**
 * leetcode 1011. 在D天内送达包裹的能力
 * @author dongdong
 * @Date 2024/1/13 9:35
 */
public class ShipWithinDays {
    public static void main(String[] args) {
        int[] weights = {1,2,3,1,1};
        int days = 4;
        System.out.println(shipWithinDays(weights, days));
    }

    /**
     * 每天的最低运载能力肯定得大于等于 tot / days 小于等于tot
     * check()得条件变复杂了
     * 需要检验在此运载能力下，需要多少天，然后和days对比
     * 时间复杂度O(nlog(sum))
     * @param weights
     * @param days
     * @return
     */
    public static int shipWithinDays(int[] weights, int days) {
        int size = weights.length;
        //只有一个包裹时，不论days是几，最小运输能力都得是该包裹的质量
        if (size == 1) return weights[0];
        int tot = 0;
        int left = 0 , right = 0;
        for (int i = 0; i < size; i++) {
            tot += weights[i];
            left = Math.max(left, weights[i]);
        }

        right = tot;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            //此运载能力小了，也就是得超过days才可以完成
            if (check(mid, weights, days)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static boolean check(int capacity, int[] weights, int days) {
        int needs = 0;
        int size = weights.length;
        int weight = 0;
        int i = 0;
        while (i < size) {
            while (i < size && weight + weights[i] <= capacity) {
                weight += weights[i];
                i++;
            }
            //因为包裹不能拆，所以在重量大于最小运输能力时，表明此运输能力是不够的
/*            if (weight == 0 && weight + weights[i] > capacity) {
                return true;
            }*/
            needs++;
            weight = 0;
        }
        return needs > days;
    }
}
