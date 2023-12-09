package com.yugutou.charpter13_math.level2;

public class AddStrings {
    public static void main(String[] args) {
        String num1 = "456", num2 = "77";
        System.out.println(addStrings(num1, num2));
    }

    /**
     * 同时倒序遍历，然后处理进位
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, pre = 0;
        StringBuilder sb = new StringBuilder();
        int temp = 0;
        while (i >= 0 || j >= 0 || pre != 0) {
            int a = i >= 0 ?  num1.charAt(i) - '0' : 0;
            int b = j >= 0 ?  num2.charAt(j) - '0' : 0;
            temp = a + b + pre;
            sb.append(temp >= 10 ? temp % 10 : temp);
            pre = temp >= 10 ? 1 : 0;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}
