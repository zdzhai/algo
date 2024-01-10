package com.yugutou.charpter12_string;

/**
 * leetcode. 409. 最长回文串
 *
 * @author dongdong
 * @Date 2024/1/10 19:33
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaaaacccc"));
    }

    /**
     * 记录字符的长度，偶数全部相加，奇数的取最大
     * 如果偶数为0，则取最大的奇数减1 + 第二大的奇数
     * 其实是奇数个数的也可以少用一个
     * <p>
     * 偶数个数的直接加，奇数个数的最大的全用上，其余的-1后用上
     * aaaaacccb
     * aaaaacc
     * caabaac
     * <p>
     * abccccdd
     * ccccdda
     *
     * @param s
     * @return
     */
    public static int longestPalindrome(String s) {
        int[] lower = new int[26];
        int[] upper = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                lower[chars[i] - 'a']++;
            } else {
                upper[chars[i] - 'A']++;
            }
        }
        int ans = 0;
        int numOdd = 0;
        for (int i = 0; i < upper.length; i++) {
            //偶数直接加，奇数先判断再加，统计奇数的个数和最大值
            if (lower[i] % 2 != 0) {
                numOdd++;
            }
            if (upper[i] % 2 != 0) {
                numOdd++;
            }
            ans += lower[i];
            ans += upper[i];
        }
        ans -= numOdd;
        if (numOdd != 0) ans += 1;

        return ans;
    }
}
