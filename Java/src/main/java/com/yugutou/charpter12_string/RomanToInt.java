package com.yugutou.charpter12_string;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 19. 罗马数字转整数
 * @author dongdong
 * @Date 2024/1/5 22:01
 */
public class RomanToInt {
    public static void main(String[] args) {
        String str = "MCMXCIV";
        System.out.println(romanToInt(str));
    }

    /**
     * 字符串转数组，然后遍历加和
     * 特殊值单独判断
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] chars = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            if ((i + 1) < chars.length && chars[i] == 'I' && (chars[i + 1] == 'V' || chars[i + 1] == 'X')) {
                ans += (map.get(chars[i + 1]) - map.get('I'));
                i++;
            }
            else if ((i + 1) < chars.length && chars[i] == 'X' && (chars[i + 1] == 'L' || chars[i + 1] == 'C')) {
                ans += (map.get(chars[i + 1]) - map.get('X'));
                i++;
            }
            else if ((i + 1) < chars.length && chars[i] == 'C' && (chars[i + 1] == 'D' || chars[i + 1] == 'M')) {
                ans += (map.get(chars[i + 1]) - map.get('C'));
                i++;
            }
            else {
                ans += map.get(chars[i]);
            }
        }
        return ans;
    }
}
