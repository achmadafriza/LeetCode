package com.practice.interview.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class S530 {
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

    public void traverseInOrder(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            traverseInOrder(root.left, values);
        }

        values.add(root.val);

        if (root.right != null) {
            traverseInOrder(root.right, values);
        }
    }

    public int getMinimumDifference(TreeNode root) {
        List<Integer> values = new ArrayList<>();

        traverseInOrder(root, values);

        int result = Integer.MAX_VALUE;
        for (int i = 1; i < values.size(); i++) {
            result = Math.min(result, values.get(i) - values.get(i - 1));
        }

        return result;
    }
}
