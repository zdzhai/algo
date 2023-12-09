package com.yugutou.charpter13_math.level2;

public class AddBinary {
    public static void main(String[] args) {
        String a = "1110", b = "1011";
        System.out.println(addBinary(a, b));
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1, pre = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || pre != 0) {
            int m = i >= 0 ? a.charAt(i) - '0' : 0;
            int n = j >= 0 ? b.charAt(j) - '0' : 0;
            int temp = m + n + pre;
            sb.append(temp >= 2 ? temp % 2 : temp);
            pre = temp >= 2 ? 1 : 0;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}
