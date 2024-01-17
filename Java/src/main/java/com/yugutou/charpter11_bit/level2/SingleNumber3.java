package com.yugutou.charpter11_bit.level2;

/**
 * @author dongdong
 * @Date 2024/1/15 20:14
 */
public class SingleNumber3 {
    public static void main(String[] args) {
        System.out.println(3 ^ 5);
    }

    /**
     * 异或的本质在于这一位的二进制数是不同的 0 ^ 1 = 1;
     * @param nums
     * @return
     */
    public static int[] singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        int[] res = new int[2];
        int k = 0;
        for (int i = 0; i < 32 && k == 0; i++) {
            if (((ans >> i) & 1) == 1) k = i;
        }
        for (int num : nums) {
            if ((num >> k & 1) == 1) res[0] ^= num;
            else res[1] ^= num;
        }
        return res;
    }
}
