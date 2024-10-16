package com.practice.interview.graph;

public class S130 {
    public void save(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }

        if (board[row][col] != 'O') {
            return;
        }

        board[row][col] = '-';

        save(board, row - 1, col);
        save(board, row + 1, col);
        save(board, row, col -1);
        save(board, row, col + 1);
    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int row = 0; row < m; row++) {
            if (board[row][0] == 'O') {
                save(board, row, 0);
            }

            if (board[row][n - 1] == 'O') {
                save(board, row, n - 1);
            }
        }

        for (int col = 0; col < n; col++) {
            if (board[0][col] == 'O') {
                save(board, 0, col);
            }

            if (board[m - 1][col] == 'O') {
                save(board, m - 1, col);
            }
        }

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == '-') {
                    board[row][col] = 'O';
                } else if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                }
            }
        }
    }
}
