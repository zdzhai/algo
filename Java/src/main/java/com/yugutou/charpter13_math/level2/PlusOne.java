package com.yugutou.charpter13_math.level2;

import java.util.Arrays;

/**
 * 数组实现整数加法
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] digital = {9,9};
        System.out.println(Arrays.toString(plusOne(digital)));
    }

    /**
     * 主要问题是第一位需要进位时溢出要怎么办
     * 如果第一位需要进位，一定时9，99，999这种数
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        int size = digits.length;
        int pre = 0;
        for (int i = size - 1; i >= 0 ; i--) {
            int temp = i == size - 1 ? digits[i] + 1 + pre : digits[i] + pre;
            digits[i] = temp >= 10 ? temp % 10 : temp;
            pre = temp >= 10 ? 1 : 0;
            if (digits[i] != 0) {
                return digits;
            }
        }
        int[] ans = Arrays.copyOf(digits, size + 1);
        ans[0] = 1;
        return ans;
    }


}
