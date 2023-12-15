package com.yugutou.charpter16_slide.level2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstringTwoDistinct {

    public static void main(String[] args) {
        String s = "eccebbba";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));
    }

    /**
     * 问题1：如何判重
     * 问题2：判重后如何更新left
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringTwoDistinct(String s) {

        if (s.length() < 3) {
            return s.length();
        }
        int left = 0, right = 1;
        Map<Character, Integer> map = new HashMap<>();
        int ans = 2;
        map.put(s.charAt(left), left);
        while (right < s.length()) {
            map.put(s.charAt(right), right++);
            if (map.size() == 3) {
                Integer del_idx = Collections.min(map.values());
                map.remove(s.charAt(del_idx));
                left = del_idx + 1;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}
