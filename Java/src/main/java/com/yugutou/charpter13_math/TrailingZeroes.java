package com.yugutou.charpter13_math;

/**
 * leetcode 172. 阶乘后的零
 * @author dongdong
 * @Date 2024/1/13 23:25
 */
public class TrailingZeroes {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(125));
    }

    /**
     * 看有多少个5
     * @param n
     * @return
     */
    public static int trailingZeroes(int n) {
        if (n < 5) return 0;
        int ans = 0;
        //是5的n次幂时，要多几个零
        for (int i = 5; i <= n; i++) {
            for (int j = i; j % 5 == 0; j /= 5) {
                ans++;
            }
        }
        return ans;
    }
}
