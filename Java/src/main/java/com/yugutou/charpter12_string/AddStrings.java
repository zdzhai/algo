package com.yugutou.charpter12_string;

/**
 * @author dongdong
 * @Date 2023/12/30 16:18
 */
public class AddStrings {
    public static void main(String[] args) {
        String num1 = "408";
        String num2 = "5";
        System.out.println(addStrings(num1, num2));
    }

    public static String addStrings(String num1, String num2) {
        if ("0".equals(num1)) {
            return num2;
        }
        if ("0".equals(num2)) {
            return num1;
        }
        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int add = 0;
        while (index2 >= 0) {
            int a = num1.charAt(index1--) - '0';
            int b = num2.charAt(index2--) - '0';
            int sum = a + b + add;
            add = sum >= 10 ? 1 : 0;
            sb.append(sum >= 10 ? sum - 10 : sum);
        }
        while (index1 >= 0) {
            int a = num1.charAt(index1--) - '0';
            int sum = a + add;
            add = sum >= 10 ? 1 : 0;
            sb.append(sum >= 10 ? sum - 10 : sum);
        }
        if (add != 0) {
            sb.append(add);
        }
        return sb.reverse().toString();
    }
}
