package com.yugutou.charpter11_bit.level2;

/**
 * @author dongdong
 * @Date 2024/1/6 11:22
 */
public class Add {
    public static void main(String[] args) {
        System.out.println(add(8,13));
    }

    /**
     * 两数相加
     * 使用不进位+进位的方式
     * 不进位的值是异或运算 0 ^ 1 = 1
     * 进位的值是与运算后左移1位
     * 再递归把进位和不进位继续相加
     * @param a
     * @param b
     * @return
     */
    public static int add(int a, int b) {
        if (b == 0) return a;
        int sum = a ^ b;
        int carry = ((a & b) << 1);
        return add(sum,carry);
    }
}
