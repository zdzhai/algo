package com.yugutou.charpter12_string.level3;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"cir","car"};
        System.out.println(longestCommonPrefix1(strs));
    }

//    第一种方式 纵向
    public static String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder ans = new StringBuilder();
        //外循环遍历第一个字符串的每一个字符
        //内循环遍历其他字符的每一个和外循环同样索引的字符
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            int j = 1;
            for (j = 1; j < strs.length; j++) {
                if( strs[j].length() <= i || strs[j].charAt(i) != ch ) {
                    break;
                }
            }
            if (j == strs.length) {
                ans.append(ch);
            } else {
                break;
            }
        }
        return ans.toString();
    }

    /**
     * 方法2 ：横向
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }
}
