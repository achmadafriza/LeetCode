package com.practice.interview.binaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class S117 {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static Node connect(Node root) {
        if (root == null) {
            return root;
        }

        if (root.left != null && root.right != null) {
            root.left.next = root.right;
        }

        Node toConnect = root.right;
        if (toConnect == null && root.left != null) {
            toConnect = root.left;
        }

        Node current = root.next;
        while (current != null && toConnect != null) {
            if (current.left != null) {
                toConnect.next = current.left;

                break;
            }

            if (current.right != null) {
                toConnect.next = current.right;

                break;
            }

            current = current.next;
        }

        root.right = connect(root.right);
        root.left = connect(root.left);

        return root;
    }

    public static void main(String[] args) {
        connect(
                new Node(
                        1,
                        new Node(2, new Node(4), new Node(5), null),
                        new Node(3, null, new Node(7), null),
                        null
                )
        );
    }
}
