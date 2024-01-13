package com.yugutou.charpter12_string;

/**
 * leetcode. 171.Excel表单序号
 * @author dongdong
 * @Date 2024/1/13 23:03
 */
public class TitleToNumber {
    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
    }

    public static int titleToNumber(String columnTitle) {
        int size = columnTitle.length();
        if (size == 1) return columnTitle.charAt(0) - 'A' + 1;
        int i = 0;
        int ans = 0;
        while (i < size) {
            ans = ans * 26 + (columnTitle.charAt(i) - 'A' + 1);
            i++;
        }
        return ans;
    }
}
