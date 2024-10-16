package com.practice.interview.matrix;

public class S289 {
    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        /* Pre-calculate Neighbours */
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                /* Calculate Neighbours */
                int neighbours = 0;

                /* upper */
                if (row - 1 >= 0 && col - 1 >= 0 && board[row - 1][col - 1] > 0) {
                    neighbours++;
                }

                if (row - 1 >= 0 && board[row - 1][col] > 0) {
                    neighbours++;
                }

                if (row - 1 >= 0 && col + 1 < n && board[row - 1][col + 1] > 0) {
                    neighbours++;
                }

                /* middle */
                if (col - 1 >= 0 && board[row][col - 1] > 0) {
                    neighbours++;
                }

                if (col + 1 < n && board[row][col + 1] > 0) {
                    neighbours++;
                }

                /* lower */
                if (row + 1 < m && col - 1 >= 0 && board[row + 1][col - 1] > 0) {
                    neighbours++;
                }

                if (row + 1 < m && board[row + 1][col] > 0) {
                    neighbours++;
                }

                if (row + 1 < m && col + 1 < n && board[row + 1][col + 1] > 0) {
                    neighbours++;
                }

                /* Alive */
                if (board[row][col] > 0) {
                    board[row][col] = neighbours + 1;
                } else {
                    /* Dead */
                    board[row][col] = -neighbours;
                }
            }
        }

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                int neighbours = board[row][col];
                switch (neighbours) {
                    case -3, 3, 4 -> board[row][col] = 1;
                    default -> board[row][col] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        gameOfLife(new int[][]{
                {1,0,0,0,0,1},{0,0,0,1,1,0},{1,0,1,0,1,0},{1,0,0,0,1,0},{1,1,1,1,0,1},{0,1,1,0,1,0},{1,0,1,0,1,1},{1,0,0,1,1,1},{1,1,0,0,0,0}
        });
    }
}
