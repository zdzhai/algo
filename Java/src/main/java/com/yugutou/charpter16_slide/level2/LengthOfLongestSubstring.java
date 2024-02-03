package com.yugutou.charpter16_slide.level2;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {

        String s = "dvdf";
//        String s = "au";
//        String s = " ";
        System.out.println(lengthOfLongestSubstring(s));

    }

    /**
     * 问题1：如何判重
     * 问题2：判重后如何移动left
     * 使用滑动窗口定位区间
     * 使用HashMap 做left更新
     * 注意dvdf这种，第二次遇到d时，是把left移到v处，而不是d处
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 1) return 1;
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 1;
        int ans = 0;
        map.put(s.charAt(l), l);
        while (r < n) {
            if (map.containsKey(s.charAt(r))) {
                l = Math.max(l,map.get(s.charAt(r)) + 1);
            }
            map.put(s.charAt(r), r);
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        if (n <= 1) {
            return n;
        }
        int l = 0,r = 0;
        //保存字符及其出现的次数
        Map<Character, Integer> map = new HashMap<>();
        int ans = 1;
        while (r < n) {
            char j = s.charAt(r);
            map.put(j, map.getOrDefault(j, 0) + 1);
            //存在r重复，要把l移动到使重复字符只剩下一个的字符后边
            while (map.get(s.charAt(r)) > 1) {
                char i = s.charAt(l);
                map.put(i, map.get(i) - 1);
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }


}
