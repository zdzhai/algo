package com.yugutou.charpter13_math.level1;

public class ConvertToBase7 {
    public static void main(String[] args) {

        System.out.println(convertToBase7(7));
    }

    public static String convertToBase7(int num) {
        boolean flag = false;
        if (num == 0) {
            return "0";
        }
        if (num < 0) {
            flag = true;
            num = -num;
        }
        //对7求余数
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 7);
            num  /= 7;
        }
        return flag ? sb.append("-").reverse().toString() : sb.reverse().toString();
    }
}

