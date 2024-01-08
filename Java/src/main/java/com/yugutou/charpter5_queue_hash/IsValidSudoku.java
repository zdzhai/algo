package com.yugutou.charpter5_queue_hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author dongdong
 * @Date 2024/1/7 21:30
 */
public class IsValidSudoku {
    public static void main(String[] args) {

    }

    /**
     * 用hash表做判重
     * @param board
     * @return
     */
    public static boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> row = new HashMap<>(9);
        Map<Integer, Set<Integer>> col = new HashMap<>(9);
        Map<Integer, Set<Integer>> area = new HashMap<>(9);

        for (int i = 0; i < board.length; i++) {
            row.put(i, new HashSet<>(9));
            col.put(i, new HashSet<>(9));
            area.put(i, new HashSet<>(9));
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char ch = board[i][j];
                if (ch == '.') continue;
                int n = ch - '0';
                int idx = (i / 3) * 3 + (j / 3);
                if (row.get(i).contains(n) || col.get(j).contains(n) ||
                area.get(idx).contains(n)) {
                    return false;
                }
                row.get(i).add(n);
                col.get(j).add(n);
                area.get(idx).add(n);
            }
        }
        return true;
    }

    /**
     * 数据范围不大时，使用数组代替hash表
     * @param board
     * @return
     */
    public static boolean isValidSudoku2(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] area = new boolean[9][9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char ch = board[i][j];
                if (ch == '.') continue;
                int n = ch - '0' - 1;
                int idx = (i / 3) * 3 + (j / 3);
                if (row[i][n] || col[j][n] || area[idx][n]) {
                    return false;
                }
                row[i][n] = true;
                col[j][n] = true;
                area[idx][n] = true;
            }
        }
        return true;
    }

    /**
     * 使用bit用来压缩空间复杂度
     * @param board
     * @return
     */
    public static boolean isValidSudoku3(char[][] board) {
        int[] row = new int[9];
        int[] col = new int[9];
        int[] area = new int[9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char ch = board[i][j];
                if (ch == '.') continue;
                int n = ch - '0' - 1;
                int idx = (i / 3) * 3 + (j / 3);
                if (((row[i] >> n) & 1) != 0
                        || ((col[j] >> n) & 1) != 0
                        || ((area[idx] >> n) & 1) != 0 ) {
                    return false;
                }
                row[i] |= 1 << n;
                col[j] |= 1 << n;
                area[idx] |= 1 << n;
            }
        }
        return true;
    }
}
