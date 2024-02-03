package com.yugutou.charpter13_math;

/**
 * leetcode 9. 回文数
 * @author dongdong
 * @Date 2024/2/2 20:04
 */
public class IsPalindrome {
    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome(10));
    }

    /**
     * 时间复杂度O(n) n为数字的长度
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x > 0 && x % 10 == 0)) return false;
        long temp = 0, t = x;
        while (t > 0) {
            temp = temp * 10 + t % 10;
            t /= 10;
        }
        return x == temp;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0 || (x > 0 && x % 10 == 0)) return false;
        int ans = 0;
        while (x > ans) {
            ans = ans * 10 + x % 10;
            x /= 10;
        }
        return ans == x || x == ans / 10;
    }
}
