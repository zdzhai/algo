package com.yugutou.charpter17_greedy.level1;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode860，
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 */
public class LemonadeChange {
    public static void main(String[] args) {
        int[] bills = {5, 5, 10, 10, 20};
        System.out.println(lemonadeChange(bills));
    }

    /**
     * 如果第一个就大于5 直接false
     * 找钱时优先找大数额的钱，因为最大额度为20，所以找零只有10和5
     * @param bills
     * @return
     */
    public static boolean lemonadeChange(int[] bills) {
        if (bills[0] > 5) {
            return false;
        }
        int cash_5 = 5;
        int cash_10 = 10;
        int num_5 = 1;
        int num_10 = 0;
        int n = bills.length;
        for (int i = 1; i < n; i++) {
            if (bills[i] == cash_5) {
                num_5++;
            }
            else if( bills[i] == cash_10 ) {
                num_10++;
                if (num_5 > 0) {
                    num_5--;
                } else {
                    return false;
                }
            } else {
                if (num_10 > 0 && num_5 > 0) {
                    num_5--;
                    num_10--;
                } else if (num_5 >= 3) {
                    num_5 -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
