package com.practice.interview.linkedlist;

public class S25 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode next = reverse(head.next);
        ListNode prev = next;
        ListNode curr = next;
        while (curr != null) {
            prev = curr;
            curr = curr.next;
        }

        prev.next = head;
        prev.next.next = null;

        return next;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode prevHead = head;
        ListNode curr = head;
        while (curr != null) {
            ListNode prev = curr;
            ListNode next = curr;
            int i = 0;
            while (i < k && next != null) {
                prev = next;
                next = next.next;

                i++;
            }

            if (i != k) {
                break;
            }

            prev.next = null;

            reverse(curr);

            if (head.next == null) {
                head = prev;
            }

            prevHead.next = prev;
            curr.next = next;

            prevHead = curr;
            curr = next;
        }

        return head;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        reverseKGroup(head, 2);
    }
}
