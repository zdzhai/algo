package com.yugutou.charpter12_string.level1;

public class MyAtoi {
    public static void main(String[] args) {

        String str = "-2147483649";
        int res = myAtoi(str);
        System.out.println(res);

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    public static int myAtoi(String str) {
        int n = str.length();
        char[] charArray = str.toCharArray();

        int index = 0;
        //去除前导空格
        while (index < n && charArray[index] == ' ') {
            index++;
        }
        if (index == n) {
            return 0;
        }
        int sign = 1;
        if (charArray[index] == '+') {
            index++;
        } else if (charArray[index] == '-') {
            index++;
            sign = -1;
        }

        int res = 0;
        while (index < n) {
            if (charArray[index] > '9' || charArray[index] < '0') {
                break;
            }

            //判断数字是否越界
            if (res > Integer.MAX_VALUE / 10
                    || (res == Integer.MAX_VALUE / 10 && (charArray[index] - '0') > (Integer.MAX_VALUE % 10))) {
                return Integer.MAX_VALUE;
            }
            else if (res < Integer.MIN_VALUE / 10
                    || (res == Integer.MIN_VALUE / 10 && (charArray[index] - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + sign * (charArray[index] - '0');
            index++;
        }

        return res;
    }
}
