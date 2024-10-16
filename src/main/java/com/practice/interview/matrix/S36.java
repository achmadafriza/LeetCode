package com.practice.interview.matrix;

import java.util.HashSet;
import java.util.Set;

public class S36 {
    public static boolean isValidSudoku(char[][] board) {
        /* horizontal */
        for (int row = 0; row < board.length; row++) {
            Set<Character> sudokuSet = new HashSet<>();
            for (int col = 0; col < board.length; col++) {
                if (Character.isDigit(board[row][col]) && sudokuSet.contains(board[row][col])) {
                    return false;
                }

                sudokuSet.add(board[row][col]);
            }
        }

        /* vertical */
        for (int col = 0; col < board.length; col++) {
            Set<Character> sudokuSet = new HashSet<>();
            for (int row = 0; row < board.length; row++) {
                if (Character.isDigit(board[row][col]) && sudokuSet.contains(board[row][col])) {
                    return false;
                }

                sudokuSet.add(board[row][col]);
            }
        }

        /* 3x3 */
        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board.length; j += 3) {
                Set<Character> sudokuSet = new HashSet<>();
                for (int row = i; row < i + 3; row++) {
                    for (int col = j; col < j + 3; col++) {
                        if (Character.isDigit(board[row][col]) && sudokuSet.contains(board[row][col])) {
                            return false;
                        }

                        sudokuSet.add(board[row][col]);
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        isValidSudoku(board);
    }
}
