package com.yugutou.charpter18_backtracking;

import java.util.Arrays;

/**
 * leetcode 130. 被围绕的区域
 * @author dongdong
 * @Date 2024/1/10 10:13
 */
public class Solve {
    public static void main(String[] args) {
        char[][] board = {
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'},
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'}
        };
        solve(board);
        System.out.println(Arrays.deepToString(board));
    }

    static boolean flag = false;
    public static void solve(char[][] board) {
        int row = board.length, col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean flag = i == 0 || j == 0
                        || i == (row - 1) || j == (col - 1);
                if (flag && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    /**
     * 判断从边界的’O‘开始，上下左右依次遍历，
     * 把和边界联通的，修改grid为’#‘
     * 最后判断把’O‘修改为’X‘（不和边界相连的）,把’#‘修改为'O'和边界相连的
     * @param board
     * @param x
     * @param y
     */
    public static void dfs(char[][] board, int x, int y) {
        //下 右 左 上
        int[][] dir = {{1,0}, {0,1}, {0,-1},{-1,0}};
        if (x < 0 || x >= board.length
                || y < 0 || y >= board[0].length
                || board[x][y] == 'X' || board[x][y] == '#') {
            return;
        }
        board[x][y] = '#';
        for (int i = 0; i < 4; i++) {
            int xx = x + dir[i][0];
            int yy = y + dir[i][1];
            dfs(board, xx, yy);
        }
    }

    public static void dfs2(char[][] board, int x, int y) {
        //下 右 左 上
        int[][] dir = {{1,0}, {0,1}, {0,-1},{-1,0}};
        board[x][y] = 'X';

        for (int i = 0; i < 4; i++) {
            int xx = x + dir[i][0];
            int yy = y + dir[i][1];
            if (xx < 0 || xx >= board.length
                    || yy < 0 || yy >= board[0].length
                    || board[xx][yy] == 'X') {
                continue;
            }
            if (board[xx][yy] == 'O' &&
                    (xx == board.length - 1 || yy == board[0].length - 1)) {
                flag = true;
                return;
            }
            board[xx][yy] = 'X';
            dfs(board, xx, yy);
            if (flag) {
                board[xx][yy] = 'O';
            }
        }
    }
}
