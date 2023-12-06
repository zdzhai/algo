package com.yugutou.charpter13_math.level1;

public class IsPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome2(10));
    }

    /**
     * 方法1 通过字符串实现
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String oldStr = "" + x;
        String newStr = new StringBuilder("" + x).reverse().toString();
        return oldStr.equals(newStr);
    }

    /**
     * 方法2：通过移位计算
     * 无法定义一个会溢出的回文数
     * 定义一个数，是回文，不会溢出；不是回文，可能溢出，返回false.
     * 将数字转为string,不然怎么知道其长度来折半
     * @param x
     * @return
     */
    public static boolean isPalindrome2(int x) {
        //负数和0
        if (x < 0 || (x % 10 == 0 && x > 0)) {
            return false;
        }
        //
        int reverse = 0;
        while (x > reverse) {
            int temp = x % 10;
            reverse = reverse * 10 + temp;
            x /= 10;
        }
        return x == reverse || x == reverse / 10;
    }

}
