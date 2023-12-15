package com.yugutou.charpter16_slide.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(findAnagrams(s, p));

    }

    /**
     * 判断数组一样的时候，记录初始位置
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }
        List<Integer> ans = new ArrayList<Integer>();
        int[] nums1 = new int[26];
        int[] nums2 = new int[26];
        for (int i = 0; i < pLen; i++) {
            nums1[p.charAt(i) - 'a']++;
            nums2[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(nums1, nums2)) {
            ans.add(0);
        }
        for (int i = pLen; i < sLen; i++) {
            nums2[s.charAt(i) - 'a']++;
            nums2[s.charAt(i - pLen) - 'a']--;
            if (Arrays.equals(nums1, nums2)) {
                ans.add(i - pLen + 1);
            }
        }
        return ans;
    }
}
