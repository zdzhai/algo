package com.yugutou.charpter3_array;

/**
 * leetcode 383. 赎金信 easy
 * @author dongdong
 * @Date 2024/1/7 20:32
 */
public class CanConstruct {
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "ab";
        System.out.println(canConstruct(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] provide = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            provide[magazine.charAt(i)- 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--provide[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
