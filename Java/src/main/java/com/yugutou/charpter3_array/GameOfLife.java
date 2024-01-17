package com.yugutou.charpter3_array;

import java.util.Arrays;

/** 289. 生命游戏
 * leetcode.
 * @author dongdong
 * @Date 2024/1/15 20:40
 */
public class GameOfLife {
    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }

    /**
     * i，j
     * 左闭右开
     * i - 1, j - 1 -- j + 1 上
     * i + 1, j - 1 == j + 1 下
     * j - 1, i - 1 -- i + 1 左
     * j + 1, i - 1 -- i + 1 右
     * <p>
     * x = i * col + j    +- 1
     * (i - 1) * col + j  +- 1
     * (i + 1) * col + j  +- 1
     *  使用位运算优化，保存改变前后结果
     * @param board
     */
    public static void gameOfLife(int[][] board) {
        int row = board.length, col = board[0].length;
        int[][] ans = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int temp = retZeroAndOne(i, j, board);
                int tar = aliveOrDeath(board[i][j], temp);
                board[i][j] |= (tar << 1);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    public static int retZeroAndOne(int x, int y, int[][] ans) {
        int one = 0;
        int k = -1;
        for (int i = x + k; k < 2; i++, k++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && i < ans.length && j >= 0 && j < ans[0].length) {
                    if ((ans[i][j] & 1) > 0) {
                        one++;
                    }
                }
            }
        }
        return ans[x][y] == 1 ? --one : one;
    }

    public static int aliveOrDeath(int alive, int death) {
        if (alive == 1) {
            if (death < 2) {
                return 0;
            } else if (death == 2 || death == 3) {
                return 1;
            } else {
                return 0;
            }
        }
        return death == 3 ? 1 : 0;
    }
}
