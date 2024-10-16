package com.practice.interview.binaryTree;

import com.sun.source.tree.Tree;

public class S114 {
    public class TreeNode {
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

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);

        flatten(root.right);

        TreeNode right = root.right;

        root.right = root.left;
        root.left = null;

        TreeNode prev = root;
        TreeNode curr = root.right;
        while (curr != null) {
            prev = curr;
            curr = curr.right;
        }

        prev.right = right;
    }
}
