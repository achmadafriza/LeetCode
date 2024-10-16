package com.practice.interview.binaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class S98 {
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

    public boolean checkTree(TreeNode root, Predicate<TreeNode> predicate) {
        if (root == null) {
            return true;
        }

        return predicate.test(root) && checkTree(root.left, predicate) && checkTree(root.right, predicate);
    }

    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean result = checkTree(root.left, treeNode -> treeNode.val < root.val);
        result = result && checkTree(root.right, treeNode -> root.val < treeNode.val);


        return result && isValidBST2(root.left) && isValidBST2(root.right);
    }

    public void traverseInOrder(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }

        traverseInOrder(root.left, values);
        values.add(root.val);
        traverseInOrder(root.right, values);
    }

    public boolean isValidBST3(TreeNode root) {
        List<Integer> values = new ArrayList<>();

        traverseInOrder(root, values);

        for (int i = 1; i < values.size(); i++) {
            if (values.get(i - 1) >= values.get(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean checkBST(TreeNode root, long low, long high) {
        if (root == null) {
            return true;
        }

        return low < root.val
                && root.val < high
                && checkBST(root.left, low, root.val)
                && checkBST(root.right, root.val, high);
    }

    public boolean isValidBST(TreeNode root) {
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
