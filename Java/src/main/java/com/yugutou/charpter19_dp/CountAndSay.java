package com.yugutou.charpter19_dp;

/**
 * leetcode. 38外观数列 mid
 * @author dongdong
 * @Date 2024/1/7 20:48
 */
public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(10));
    }

    /**
     * 使用dp
     * dp[i] = f(dp[i - 1]);
     * @param n
     * @return
     */
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String[] dp = new String[n];
        dp[0] = "1";
        for (int i = 1; i < n; i++) {
            dp[i] = description(dp[i - 1]);
        }
        return dp[n - 1];
    }

    public static String description(String str) {
        StringBuilder ans = new StringBuilder();
        char[] chars = str.toCharArray();
        int len = str.length();
        int left = 0, right = 0;
        while (right < len) {
            while (right < len - 1 && chars[right] == chars[right + 1]) {
                right++;
            }
            ans.append(right - left + 1);
            ans.append(chars[left]);
            left = right + 1;
            right++;
        }
        return ans.toString();
    }

}
