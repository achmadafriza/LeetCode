package com.practice.interview.graph;

public class S200 {
    public void propagateIsland(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }

        if (grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';

        propagateIsland(grid, row - 1, col);
        propagateIsland(grid, row + 1, col);
        propagateIsland(grid, row, col -1);
        propagateIsland(grid, row, col + 1);
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int result = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == '1') {
                    result++;

                    propagateIsland(grid, row, col);
                }
            }
        }

        return result;
    }
}
