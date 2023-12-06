package com.yugutou.charpter13_math.level1;

public class Reverse {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Math.pow(2,31)-1);
        //System.out.println(2^30 - 1);
        System.out.println(reverse(432));
    }
    public static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int temp = x % 10;
            //数字大于214748364直接溢出
            //或者数字等于214748364，但是末尾位数字大于7
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && temp > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && temp < -8)) {
                return 0;
            }
            res = (res * 10) + temp;
            x /= 10;
        }
        return res;
    }
}
