package com.yugutou.charpter3_array;

/**
 * leetcode 2660. 保龄球游戏的获胜者
 * @author dongdong
 * @Date 2023/12/27 21:15
 */
public class IsWinner {
    public static void main(String[] args) {
        int[] player1 = {3,6,10,8};
        int[] player2 = {9,9,9,9};
        System.out.println(isWinner(player1, player2));
    }

    /**
     * 两人是等价的，所以需要一个计算分数的函数
     *
     * @param player1
     * @param player2
     * @return
     */
    public static int isWinner(int[] player1, int[] player2) {
        int score1 = calcScore(player1);
        int score2 = calcScore(player2);
        if (score1 == score2) return 0;
        return score1 > score2 ? 1 : 2;
    }

    public static int calcScore(int[] player) {
        int n = player.length;
        int score = player[0];
        for (int i = 1; i < n; i++) {
            if (i >= 2 && ( player[i - 1] == 10 || player[i - 2] == 10)) {
                score += player[i] * 2;
            }
            else if (player[i - 1] == 10) {
                score += player[i] * 2;
            }
            else {
                score += player[i];
            }
        }
        return score;
    }
}
