package com.practice.interview.binaryTree;

public class S124 {
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

    private int maxPath;

    public int recursivePathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = Math.max(recursivePathSum(root.left), 0);
        int rightSum = Math.max(recursivePathSum(root.right), 0);

        maxPath = Math.max(maxPath, leftSum + rightSum + root.val);

        return root.val + Math.max(leftSum, rightSum);
    }

    public int maxPathSum(TreeNode root) {
        maxPath = Integer.MIN_VALUE;
        recursivePathSum(root);

        return maxPath;
    }
}
