package com.yugutou.charpter13_math.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArrayForm {
    public static void main(String[] args) {
        int[] arr = {1, 2};
        int k = 998;
        List<Integer> result = addToArrayForm(arr, k);
        System.out.println(result.toString());
    }

    /**
     * 两个数相加
     * @param num
     * @param k
     * @return
     */
    public static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<Integer>();
        int size = num.length;
        int i = size - 1;
        int pre = 0;
        while (k > 0 || i >= 0 || pre != 0) {
            int a = i >= 0 ? num[i] : 0;
            int b = k >= 0 ? k % 10 : 0;
            int temp = a + b + pre;
            res.add(temp >= 10 ? temp % 10 : temp);
            pre = temp >= 10 ? 1 : 0;
            i--;
            k /= 10;
        }
        Collections.reverse(res);
        return res;
    }
}
