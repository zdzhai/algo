package com.yugutou.charpter9_bitree_bisearch;

/**
 * leetcode 1208.尽可能使字符串相等
 * @author dongdong
 * @Date 2024/1/21 15:18
 */
public class EqualSubstring {
    public static void main(String[] args) {
        String s = "abcd", t = "bcdf";
        System.out.println(equalSubstring(s,t,3));
    }

    /**
     * 如果将所有字符都变换后需要的cost大于maxCount，那变化字符个数就要严格减小
     * 最终得到在maxCost允许下可变化的最大长度
     * 题目中说是子字符串，所以应该考虑是连续的
     * @param s
     * @param t
     * @param maxCost
     * @return
     */
    public static int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        s = " " + s;
        t = " " + t;
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();

        //前缀和
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++){
            sum[i] = sum[i - 1] + Math.abs(ch1[i] - ch2[i]);
        }

        int l = 1, r = n;
        while (l < r) {
            int mid = l + 1 + ((r - l ) >> 1);
            //if(true) 长度为mid时大于maxCost
            if (!check(sum, mid, maxCost)) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return check(sum, r, maxCost) ? r : -1;
    }

    /**
     * 可变化len个字符还是连续字符 时的最小花费
     *
     * @param sum 前缀和
     * @param len 可变化的字符个数
     * @param maxCost
     * @return
     */
    private static boolean check(int[] sum, int len, int maxCost) {
        for (int i = 0; i < sum.length - len; i++) {
            if (sum[len + i] - sum[i] <= maxCost) return true;
        }
        return false;
    }

    /**
     * 有了前缀和后直接使用滑动窗口即可
     * @param s
     * @param t
     * @param maxCost
     * @return
     */
    public static int equalSubstring2(String s, String t, int maxCost) {
        int n = s.length();
        s = " " + s;
        t = " " + t;
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();

        //前缀和
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + Math.abs(ch1[i] - ch2[i]);
        }

        int l = 0, r = 0;
        int ans = 0;
        while (r <= n) {
            if (sum[r] - sum[l] > maxCost) {
                l++;
            } else {
                ans = Math.max(ans, r - l);
                r++;
            }
        }
        return ans;
    }
}
