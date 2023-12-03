package com.yugutou.charpter11_bit.level2;

/**
 * @author dongdong
 * @Date 2023/12/3 15:42
 */
public class GetSum {
    public static void main(String[] args) {
        int sum = getSum(4, 5);
        System.out.println(sum);
    }

    /**
     * 100
     * 101
     * @param a
     * @param b
     * @return
     */
    public static int getSum(int a, int b) {
        while (b != 0) {
            int sign = (a & b) << 1;
            a = a ^ b;
            b = sign;
        }
        return a;
    }
}
