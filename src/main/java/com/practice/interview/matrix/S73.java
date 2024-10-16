package com.practice.interview.matrix;

public class S73 {
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowZeroed = false;
        for (int row = 0; row < m; row++) {
            firstRowZeroed = firstRowZeroed || matrix[row][0] == 0;
        }

        boolean firstColZeroed = false;
        for(int col = 0; col < n; col++) {
            firstColZeroed = firstColZeroed || matrix[0][col] == 0;
        }

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        for (int row = 1; row < m; row++) {
            if (matrix[row][0] == 0) {
                for (int col = 1; col < n; col++) {
                    matrix[row][col] = 0;
                }
            }
        }

        for (int col = 1; col < n; col++) {
            if (matrix[0][col] == 0) {
                for (int row = 1; row < m; row++) {
                    matrix[row][col] = 0;
                }
            }
        }

        if (firstRowZeroed) {
            for (int row = 0; row < m; row++) {
                matrix[row][0] = 0;
            }
        }

        if (firstColZeroed) {
            for (int col = 0; col < n; col++) {
                matrix[0][col] = 0;
            }
        }
    }

    public static void main(String[] args) {
        setZeroes(new int[][]{
                {0, 1}
        });
    }
}
