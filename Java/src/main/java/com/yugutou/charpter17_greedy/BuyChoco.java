package com.yugutou.charpter17_greedy;

import java.util.Arrays;

/**
 * leetcode 2706
 * @author dongdong
 * @Date 2023/12/29 13:19
 */
public class BuyChoco {
    public static void main(String[] args) {
        int[] prices = {3,2,3};
        int money = 3;
        System.out.println(buyChoco(prices, money));
    }
    public static int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int count = prices[0] + prices[1];
        return count > money ? money : money- count;
    }
}
