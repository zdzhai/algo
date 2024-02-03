package com.yugutou.charpter12_string;

/**
 * leetcode 6.Z字形变换
 * @author dongdong
 * @Date 2024/2/2 20:21
 */
public class Convert {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度O(n)
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        int n = s.length();
        if (n == 1 || numRows == 1) return s;

        StringBuilder sb = new StringBuilder();

        /**
         * 公差为2(n - 1)
         */
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                int j = i;
                int mul = 2 * (numRows - 1);
                while (j < n) {
                    sb.append(s.charAt(j));
                    j += mul;
                }
            } else {
                //两个公差为2(n - 1)的数列交替打印，起始项为i和2(n - 1) - i
                int mul = 2 * (numRows - 1);
                int j1 = i, j2 = mul - i;
                while (j1 < n || j2 < n) {
                    if (j1 < n) {
                        sb.append(s.charAt(j1));
                        j1 += mul;
                    }
                    if (j2 < n) {
                        sb.append(s.charAt(j2));
                        j2 += mul;
                    }
                }
            }
        }
        return sb.toString();
    }
}
