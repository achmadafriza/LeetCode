package com.practice.interview.binaryTree;

public class S129 {
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

    public int calcNumbers(TreeNode root, int currSum) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return currSum * 10 + root.val;
        }

        return calcNumbers(root.left, currSum * 10 + root.val) + calcNumbers(root.right, currSum * 10 + root.val);
    }

    public int sumNumbers(TreeNode root) {
        return calcNumbers(root, 0);
    }
}
