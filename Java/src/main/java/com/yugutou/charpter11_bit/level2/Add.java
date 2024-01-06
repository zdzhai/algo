package com.yugutou.charpter11_bit.level2;

/**
 * @author dongdong
 * @Date 2024/1/6 11:22
 */
public class Add {
    public static void main(String[] args) {
        System.out.println(add(8,13));
    }

    public static int add(int a, int b) {
        if (b == 0) return a;
        int sum = a ^ b;
        int carry = ((a & b) << 1);
        return add(sum,carry);
    }
}
