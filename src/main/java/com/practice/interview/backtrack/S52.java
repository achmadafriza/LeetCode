package com.practice.interview.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class S52 {
    public static boolean validIndex(int[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board.length;
    }

    public static boolean checkCollision(int[][] board, int row, int col) {
        for (int i = 0; i < board.length; i++) {
            if (validIndex(board, row - i, col) && board[row - i][col] == 1) {
                return true;
            }

            if (validIndex(board, row + i, col) && board[row + i][col] == 1) {
                return true;
            }

            if (validIndex(board, row, col - i) && board[row][col - i] == 1) {
                return true;
            }

            if (validIndex(board, row, col + i) && board[row][col + i] == 1) {
                return true;
            }

            if (validIndex(board, row - i, col - i) && board[row - i][col - i] == 1) {
                return true;
            }

            if (validIndex(board, row + i, col - i) && board[row + i][col - i] == 1) {
                return true;
            }

            if (validIndex(board, row - i, col + i) && board[row - i][col + i] == 1) {
                return true;
            }

            if (validIndex(board, row + i, col + i) && board[row + i][col + i] == 1) {
                return true;
            }
        }

        return false;
    }

    public static int calcNQueens(int[][] board, int row) {
        if (row == board.length) {
            return 1;
        }

        int result = 0;
        for (int col = 0; col < board.length; col++) {
            if (!checkCollision(board, row, col)) {
                board[row][col] = 1;

                result += calcNQueens(board, row + 1);

                board[row][col] = 0;
            }
        }

        return result;
    }

    public static int totalNQueens(int n) {
        return calcNQueens(new int[n][n], 0);
    }

    public static void main(String[] args) {
        totalNQueens(4);
    }
}
