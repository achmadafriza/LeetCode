package com.practice.interview.binaryTree;

import com.sun.source.tree.Tree;

public class S230 {
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

    private TreeNode result;

    public int findkthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        int left = findkthSmallest(root.left, k);

        if (k == left + 1) {
            result = root;
        }

        int right = findkthSmallest(root.right, k - (left + 1));

        return left + 1 + right;
    }

    public int kthSmallest(TreeNode root, int k) {
        result = null;

        findkthSmallest(root, k);

        return result.val;
    }
}
