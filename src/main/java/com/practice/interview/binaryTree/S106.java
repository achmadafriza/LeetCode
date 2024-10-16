package com.practice.interview.binaryTree;

import java.util.Arrays;

public class S106 {
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

    /* Inorder = left -> root -> right */
    /* Postorder = Left -> Right -> Root */
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postorder.length - 1]);

        int i = 0;
        while (i < inorder.length) {
            if (inorder[i] == root.val) {
                break;
            }

            i++;
        }

        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, i);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, i);

        int[] rightPostorder = Arrays.copyOfRange(postorder, i, postorder.length - 1);
        int[] rightInorder = Arrays.copyOfRange(inorder, i + 1, inorder.length);

        root.left = buildTree(leftInorder, leftPostorder);
        root.right = buildTree(rightInorder, rightPostorder);

        return root;
    }

    public static void main(String[] args) {
        buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
    }
}
