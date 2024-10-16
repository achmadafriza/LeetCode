package com.practice.interview.linkedlist;

public class S19 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
          
    public ListNode removeNthFromEnd(ListNode head, int n) {
        head = new ListNode(0, head);
        ListNode prev = head;
        ListNode curr = head;

        for (int i = 0; i < n; i++) {
            curr = curr.next;
        }

        while (curr.next != null) {
            prev = prev.next;
            curr = curr.next;
        }

        prev.next = prev.next.next;

        return head.next;
    }
}
