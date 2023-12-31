package com.yugutou.charpter3_array;

import java.util.Arrays;

/**
 * @author dongdong
 * @Date 2023/12/31 10:30
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {1,3,1,-1};
        int target = 5;
        System.out.println(threeSumClosest(nums, target));
    }

    /**
     * 先排序
     * 然后用双指针
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int a, b, c;
        int sum;
        int offset = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        for (a = 0; a < n - 2; a++) {
            b = a + 1;
            c = n - 1;
            while (b < c) {
                sum = nums[a] + nums[b] + nums[c];
                if ((sum - target) > 0) {
                    c--;
                }
                else if ((sum - target) < 0) {
                    b++;
                }
                else {
                    return sum;
                }
                if (offset >  Math.abs(sum - target)) {
                    offset = Math.abs(sum - target);
                    ans = sum;
                }
            }
        }
        return ans;
    }
}
