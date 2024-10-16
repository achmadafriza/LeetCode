package com.practice.interview.binaryTree;

public class S236 {
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

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode leftDescendant = lowestCommonAncestor(root.left, p, q);
        TreeNode rightDescendant = lowestCommonAncestor(root.right, p, q);

        if (leftDescendant != null && rightDescendant != null) {
            return root;
        }

        if (leftDescendant != null) {
            return leftDescendant;
        }

        return rightDescendant;
    }

    public static void main(String[] args) {
        lowestCommonAncestor(new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3)), new TreeNode(4), new TreeNode(3));
    }
}
