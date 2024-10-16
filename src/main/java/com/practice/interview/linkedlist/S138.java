package com.practice.interview.linkedlist;

public class S138 {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node current = head;
        while (current != null) {
            Node temp = current.next;

            current.next = new Node(current.val);
            current.next.next = temp;

            current = temp;
        }

        current = head;
        while (current != null) {
            current.next.random = current.random;
            if (current.next.random != null) {
                current.next.random = current.next.random.next;
            }

            current = current.next.next;
        }

        current = head;
        head = current.next;
        while (current != null) {
            Node temp = current.next;

            if (current.next != null) {
                current.next = current.next.next;
            }

            current = temp;
        }

        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.random = head;
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.random = head.next.next;
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.random = head;

        head.next.next.random = head.next.next.next.next;

        copyRandomList(head);
    }
}
