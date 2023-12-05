package com.yugutou.charpter12_string.level2;

public class IsPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));

    }

    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }
        String origin = sb.toString();
        StringBuilder reverse = sb.reverse();
        return origin.equals(reverse.toString());
    }
}
