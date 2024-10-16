package com.practice.interview.linkedlist;

public class S61 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode curr = head;
        int i = 1;
        while (curr.next != null) {
            curr = curr.next;
            i++;
        }

        curr.next = head;
        k = i - (k % i);
        i = 0;

        ListNode prev = head;
        ListNode start = head;
        while (i < k) {
            prev = start;
            start = start.next;
            i++;
        }

        prev.next = null;

        return start;
    }

    public static void main(String[] args) {
        rotateRight(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))),  2);
    }
}
