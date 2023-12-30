package com.yugutou.charpter12_string;

/**
 * @author dongdong
 * @Date 2023/12/30 16:06
 */
public class Multiply {
    public static void main(String[] args) {
        String num1 = "999";
        String num2 = "999";
        System.out.println(multiply(num1, num2));
    }

    public static String multiply(String num1, String num2) {
        /*long a = str2Num(num1);
        long b = str2Num(num2);
        return String.valueOf(a * b);*/
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        int index1, index2 = num2.length() - 1;
        int add;
        StringBuilder sb1;
        String ans = "0";
        while (index2 >= 0) {
            int b = num2.charAt(index2) - '0';
            index1 = num1.length() - 1;
            sb1 = new StringBuilder();
            add = 0;
            while (index1 >= 0) {
                int a = num1.charAt(index1--) - '0';
                int sum = a * b + add;
                add = sum >= 10 ? sum / 10 : 0;
                sb1.append(sum >= 10 ? sum % 10 : sum);
            }
            if (add != 0) {
                sb1.append(add);
            }
            sb1 = sb1.reverse();
            for (int i = 0; i < num2.length() - 1 - index2; i++) {
                sb1.append("0");
            }
            index2--;
            ans = addStrings(ans,sb1.toString());
        }
        return ans;
    }

    /**
     * 1 = 1
     * 1 * 10 + 2 12
     * 12*10 + 3 = 123
     * @param num
     * @return
     */
    private static long str2Num(String num) {
        long ans = 0;
        char[] chars = num.toCharArray();
        for (char ch : chars) {
            ans = ans * 10 +  (ch - '0');
        }
        return ans;
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
