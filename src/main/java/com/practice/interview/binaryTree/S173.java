package com.practice.interview.binaryTree;

import java.util.Stack;

public class S173 {
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

    static class BSTIterator {
        private Stack<TreeNode> callStack;

        private TreeNode currentNode;

        public BSTIterator(TreeNode root) {
            this.currentNode = root;
            this.callStack = new Stack<>();

            while (this.currentNode != null) {
                callStack.add(this.currentNode);

                this.currentNode = this.currentNode.left;
            }
        }

        public int next() {
            this.currentNode = callStack.pop();

            if (this.currentNode.right != null) {
                TreeNode next = this.currentNode.right;

                callStack.add(next);
                while (next.left != null) {
                    callStack.add(next.left);
                    next = next.left;
                }
            }

            return this.currentNode.val;
        }

        public boolean hasNext() {
            return !callStack.isEmpty();
        }
    }

    public static void main(String[] args) {
        BSTIterator iterator = new BSTIterator(new TreeNode(7, new TreeNode(3), new TreeNode(15, new TreeNode(9), new TreeNode(20))));

        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
    }
}
