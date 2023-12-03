package com.yugutou.charpter11_bit.level2;

/**
 * @author dongdong
 * @Date 2023/12/3 16:04
 */
public class Mutiply {
    public static void main(String[] args) {
        int multiply = multiply(8, 5);
        System.out.println(multiply);
    }
    public static int multiply(int A, int B) {
        int min = Math.min(A, B);
        int max = Math.max(A, B);
        int ans = 0;
        //这种方法一直都是循环32次
        //增加temp变量，减少循环次数
        int temp = min;
        for (int i = 0; i < 32 && temp != 0; i++) {
            if(( (min >> i) & 1) == 1) {
                ans += max << i;
            }
            temp >>= 1;
        }
        return ans;
    }

    /**
     * 111
     * 101
     * @param A
     * @param B
     * @return
     */
    public static int multiply2(int A, int B) {
        int min = Math.min(A, B);
        int max = Math.max(A, B);
        int ans = 0;
        for (int i = 0; min != 0; i++) {
            if ((min & 1) == 1) {
                ans += max;
            }
            min >>= 1;
            max += max;
        }
        return ans;
    }
}
