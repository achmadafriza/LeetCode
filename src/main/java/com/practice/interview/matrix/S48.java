package com.practice.interview.matrix;

import java.util.Arrays;

public class S48 {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int col = 0; i + col < n; col++) {
                int tRow = n - col - 1;
                int tCol = n - i - 1;

                int temp = matrix[tRow][tCol];
                matrix[tRow][tCol] = matrix[i][col];
                matrix[i][col] = temp;
            }
        }

        int left = 0;
        int right = n - 1;
        while (left < right) {
            int[] temp = matrix[left];
            matrix[left] = matrix[right];
            matrix[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        rotate(new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        });
    }
}
