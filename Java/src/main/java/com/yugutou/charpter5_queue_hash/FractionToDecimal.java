package com.yugutou.charpter5_queue_hash;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode. 166. 分数转小数
 * @author dongdong
 * @Date 2024/1/14 14:56
 */
public class FractionToDecimal {
    public static void main(String[] args) {
        System.out.println(fractionToDecimal(Integer.MIN_VALUE,-1));
    }

    public static String fractionToDecimal(int numerator,
                                           int denominator) {
        //判断符号
        int sign = (numerator ^ denominator) > 0 ? 1 : -1;
        long a = numerator, b = denominator;
        if (a < 0) a = -a;
        if (b < 0) b = -b;
        if (a == 0) return "0";
        StringBuilder sb = new StringBuilder();
        if (sign < 0) {
            sb.append("-");
        }
        if (a >= b) {
            sb.append(a / b);
            a %= b;
        } else {
            sb.append("0");
        }
        if (a == 0) return sb.toString();
        sb.append(".");
        //余数和字符串长度的映射
        Map<Long, Integer> map = new HashMap<>();
        while (a != 0) {
            map.put(a, sb.length());
            a *= 10;
            sb.append(a / b);
            a %= b;
            if (map.containsKey(a)) {
                int temp = map.get(a);
                return String.format("%s(%s)", sb.substring(0,temp), sb.substring(temp, sb.length()));
            }
        }
        return sb.toString();
    }
}
