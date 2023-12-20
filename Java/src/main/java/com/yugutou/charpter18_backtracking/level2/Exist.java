package com.yugutou.charpter18_backtracking.level2;

/**
 * leetcode79
 */
class Exist {
    public boolean exist(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board,
                         boolean[][] visited,
                         int i,
                         int j,
                         String s,
                         int startIndex) {
        //边界条件
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || visited[i][j]) {
            return false;
        }
        if (board[i][j] != s.charAt(startIndex)) {
            return false;
        }
        //结束条件
        if (startIndex == s.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        boolean res = check(board, visited, i, j + 1, s, startIndex + 1) ||
                check(board, visited, i + 1, j, s, startIndex + 1) ||
                check(board, visited, i, j - 1, s, startIndex + 1) ||
                check(board, visited, i - 1, j, s, startIndex + 1);
        visited[i][j] = false;
        return res;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        Exist exist = new Exist();
        System.out.println(exist.exist(board, word));
    }
}