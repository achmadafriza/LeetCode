package com.practice.interview.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class S199 {
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

    public void traverseRightMost(TreeNode root, List<Integer> result, int height) {
        if (root == null) {
            return;
        }

        if (height == result.size()) {
            result.add(root.val);
        }

        traverseRightMost(root.right, result, height + 1);
        traverseRightMost(root.left, result, height + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        traverseRightMost(root, result, 0);

        return result;
    }
}
