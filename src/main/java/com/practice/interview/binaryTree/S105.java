package com.practice.interview.binaryTree;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class S105 {
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

    /* Inorder = left -> root -> right */
    /* Preorder = root -> left -> right */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);

        int i = 0;
        while (i < inorder.length) {
            if (inorder[i] == preorder[0]) {
                break;
            }

            i++;
        }

        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1 + i);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, i);

        int[] rightPreorder = Arrays.copyOfRange(preorder, 1 + leftPreorder.length, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, i + 1, inorder.length);

        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);

        return root;
    }
}
