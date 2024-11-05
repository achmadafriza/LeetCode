package com.practice.interview.divide;

public class S427 {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    public int[][][] split(int[][] grid) {
        int n = grid.length;

        int newLength = n / 2;
        int[][][] result = new int[4][newLength][newLength];

        /* top left */
        int[][] newGrid = new int[newLength][newLength];
        for (int row = 0; row < newLength; row++) {
            for (int col = 0; col < newLength; col++) {
                newGrid[row][col] = grid[row][col];
            }
        }

        result[0] = newGrid;

        /* top right */
        newGrid = new int[newLength][newLength];
        for (int row = 0; row < newLength; row++) {
            for (int col = 0; col < newLength; col++) {
                newGrid[row][col] = grid[row][col + newLength];
            }
        }

        result[1] = newGrid;

        /* bottom left */
        newGrid = new int[newLength][newLength];
        for (int row = 0; row < newLength; row++) {
            for (int col = 0; col < newLength; col++) {
                newGrid[row][col] = grid[row + newLength][col];
            }
        }

        result[2] = newGrid;

        /* bottom right */
        newGrid = new int[newLength][newLength];
        for (int row = 0; row < newLength; row++) {
            for (int col = 0; col < newLength; col++) {
                newGrid[row][col] = grid[row + newLength][col + newLength];
            }
        }

        result[3] = newGrid;

        return result;
    }

    public Node construct(int[][] grid) {
        if (grid.length == 0) {
            return null;
        }

        Node node = new Node();

        node.isLeaf = true;
        node.val = grid[0][0] == 1;
        int val = grid[0][0];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid.length; col++) {
                if (val != grid[row][col]) {
                    int[][][] newGrid = split(grid);

                    return new Node(
                            node.val,
                            false,
                            construct(newGrid[0]),
                            construct(newGrid[1]),
                            construct(newGrid[2]),
                            construct(newGrid[3])
                    );
                }
            }
        }

        return node;
    }
}
