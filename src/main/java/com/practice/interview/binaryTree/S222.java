package com.practice.interview.binaryTree;

public class S222 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int countNodesAtHeight(TreeNode root, int height, int target) {
        if (root == null) {
            return 0;
        }

        if (height == target) {
            return 1;
        }

        return countNodesAtHeight(root.left, height + 1, target) + countNodesAtHeight(root.right, height + 1, target);
    }

    public int countNodes(TreeNode root) {
        TreeNode node = root;

        int height = 0;
        while (node != null) {
            node = node.left;
            height++;
        }

        int result = 0;
        for (int i = 0; i < height - 1; i++) {
            result += (int) Math.pow(2, i);
        }

        return result + countNodesAtHeight(root, 0, height - 1);
    }
}
