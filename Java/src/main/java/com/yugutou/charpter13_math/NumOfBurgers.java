package com.yugutou.charpter13_math;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author dongdong
 * @Date 2023/12/26 20:40
 */
public class NumOfBurgers {
    public static void main(String[] args) {
        System.out.println(numOfBurgers(16,7));
        System.out.println(numOfBurgers2(16,7));
    }

    /**
     * 鸡兔同笼问题
     * 暴力解法
     * @param tomatoSlices
     * @param cheeseSlices
     * @return
     */
    public static List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> ans = new LinkedList<>();
        if (tomatoSlices == 0 && cheeseSlices == 0) {
            ans.add(0);
            ans.add(0);
            return ans;
        }
        int totOfBig = cheeseSlices;
        int totOfSmall = 0;
        for (int i = totOfBig; i >= 0; i--) {
            int tomato = (totOfBig * 4 + totOfSmall * 2);
            int cheese = (totOfBig + totOfSmall);
            if ( tomato == tomatoSlices && cheese == cheeseSlices) {
                ans.add(totOfBig);
                ans.add(totOfSmall);
                break;
            }
            else {
                totOfBig--;
                totOfSmall++;
            }
        }
        return ans;
    }

    public static List<Integer> numOfBurgers2(int tomatoSlices, int cheeseSlices) {
        if (tomatoSlices % 2 != 0 || tomatoSlices < cheeseSlices << 1 || cheeseSlices << 2 < tomatoSlices) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(tomatoSlices / 2 - cheeseSlices);
        ans.add(cheeseSlices * 2 - tomatoSlices / 2);
        return ans;
    }
}
