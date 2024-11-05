package com.practice.interview.graph;

import java.util.*;

public class S909 {
    public static void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }

        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }


    public static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static int rowIndex(int num, int n) {
        return ((n - 1) - (num / n)) % n;
    }

    public static int colIndex(int num, int n) {
        return num % n;
    }

    public static int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[][] score = new int[n][n];

        for (int i = n % 2; i < n; i += 2) {
            reverse(board[i], 0, n - 1);
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                score[row][col] = -1;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        score[rowIndex(0, n)][colIndex(0, n)] = 0;

        while (!queue.isEmpty()) {
            int num = queue.poll();

            int row = rowIndex(num, n);
            int col = colIndex(num, n);
            for (int i = num + 1; i <= num + 6 && i < n * n; i++) {
                int jumpRow = rowIndex(i, n);
                int jumpCol = colIndex(i, n);

                int jumpTo = board[jumpRow][jumpCol];
                if (jumpTo != -1) {
                    jumpTo--;
                    jumpRow = rowIndex(jumpTo, n);
                    jumpCol = colIndex(jumpTo, n);
                } else {
                    jumpTo = i;
                }

                if (score[jumpRow][jumpCol] == -1) {
                    score[jumpRow][jumpCol] = 1 + score[row][col];
                    queue.add(jumpTo);
                }
            }
        }

        return score[rowIndex(n * n - 1, n)][colIndex(n * n - 1, n)];
    }

    public static void main(String[] args) {
        snakesAndLadders(new int[][]{
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,35,-1,-1,13,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,15,-1,-1,-1,-1}
        });

//        snakesAndLadders(new int[][]{
//                {1, 1, -1},
//                {1, 1, 1},
//                {-1, 1, 1}
//        });

//        snakesAndLadders(new int[][]{
//                {-1,-1,-1,-1,48,5,-1},
//                {12,29,13,9,-1,2,32},
//                {-1,-1,21,7,-1,12,49},
//                {42,37,21,40,-1,22,12},
//                {42,-1,2,-1,-1,-1,6},
//                {39,-1,35,-1,-1,39,-1},
//                {-1,36,-1,-1,-1,-1,5}
//        });
    }
}
