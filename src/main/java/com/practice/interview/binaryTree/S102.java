package com.practice.interview.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class S102 {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.add(root);
        }

        List<List<Integer>> nodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> levelNodes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                levelNodes.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            nodes.add(levelNodes);
        }

        return nodes;
    }
}
