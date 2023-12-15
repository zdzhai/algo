package com.yugutou.charpter16_slide.level2;

import java.util.Arrays;

public class CheckInclusion {
    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }

    /**
     * 思路1：使用固定滑动窗口，遍历的时候排序比较s1和窗口值，但这样会很慢
     * 思路2：使用map1记录s1中的元素和个数，滑动的时候记录窗口内的map2，
     * 进行比较，一致则true
     * 思路3：优化思路2，将map该为nums[26]
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion(String s1, String s2) {
        int sLen1 = s1.length(), sLen2 = s2.length();
        if (sLen1 > sLen2) {
            return false;
        }
        int[] nums1 = new int[26];
        int[] nums2 = new int[26];
        for (int i = 0; i < sLen1; i++) {
            nums1[s1.charAt(i) - 'a']++;
            nums2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(nums1, nums2)) {
            return true;
        }
        for (int i = sLen1; i < sLen2; i++) {
            nums2[s2.charAt(i) - 'a']++;
            nums2[s2.charAt(i - sLen1)- 'a']--;
            if (Arrays.equals(nums1, nums2)) {
                return true;
            }
        }
        return false;
    }
}
