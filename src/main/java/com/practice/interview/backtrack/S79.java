package com.practice.interview.backtrack;

public class S79 {
    public boolean check(char[][] board, char[] word, int i, int row, int col) {
        if (i == word.length) {
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }

        boolean result = false;
        if (board[row][col] == word[i]) {
            board[row][col] = '.';

            result = check(board, word, i + 1, row - 1, col);
            result = result || check(board, word, i + 1, row + 1, col);
            result = result || check(board, word, i + 1, row, col - 1);
            result = result || check(board, word, i + 1, row, col + 1);

            board[row][col] = word[i];
        }

        return result;
    }

    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (check(board, word.toCharArray(), 0, row, col)) {
                    return true;
                }
            }
        }

        return false;
    }
}
