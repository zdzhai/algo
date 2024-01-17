package com.yugutou.charpter3_array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * leetcode 179.最大数
 * @author dongdong
 * @Date 2024/1/14 16:18
 */
public class LargestNumber {
    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(largestNumber(nums));
    }

    /**
     * 按照位进行排序，第一位相同的，按照第二位排序
     * 没有第二位的话，第二位就是9
     * 这种会出现问题
     * a = 201 b = 20
     * a = 203 b = 20 这两种的顺序是不同的。
     * @param nums
     * @return
     */
    public static String largestNumber(int[] nums) {
        int size = nums.length;
        String[] strs = new String[size];
        for (int i = 0; i < size; i++) {
            strs[i] = "" + nums[i];
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String ab = a + b, ba = b + a;
                return ba.compareTo(ab);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(strs[i]);
        }
        int k = 0, len = sb.length();
        while (k < len - 1 && sb.charAt(k) == '0') {
            k++;
        }
        return sb.substring(k);
    }
}
