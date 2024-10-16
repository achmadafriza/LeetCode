package com.practice.interview.matrix;

import java.util.ArrayList;
import java.util.List;

public class S54 {
    public void traverse(List<Integer> result, int[][] matrix, int nRow, int nCol, int row, int col, int dr, int dc) {
        if (nRow == 0 || nCol == 0) {
            return;
        }

        for (int i = 0; i < nCol; i++) {
            row += dr;
            col += dc;

            result.add(matrix[row][col]);
        }

        traverse(result, matrix, nCol, nRow - 1, row, col, dc, -dr);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        traverse(result, matrix, matrix.length, matrix[0].length, 0, -1, 0, 1);

        return result;
    }
}
