package com.yugutou.charpter11_bit.level2;

/**
 * leetcode. 137. 只出现一次的数字2
 * @author dongdong
 * @Date 2024/1/15 19:42
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {30000,500,100,30000,100,30000,100};
        System.out.println(singleNumber(nums));
    }

    /**
     * 出现三次的数，其对应的二进制位1的个数也是3的整数倍
     * 有高级的解法，暂未掌握
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int tot = 0;
            for (int num : nums) {
                if (((num >> i) & 1) == 1) {
                    tot++;
                }
            }
            if (tot % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
