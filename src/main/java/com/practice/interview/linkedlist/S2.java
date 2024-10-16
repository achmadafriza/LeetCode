package com.practice.interview.linkedlist;

public class S2 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

        ListNode head = new ListNode();
        ListNode current = head;
        while (l1 != null && l2 != null) {
            current.next = new ListNode((l1.val + l2.val + carry) % 10);
            carry = (l1.val + l2.val +carry) / 10;

            l1 = l1.next;
            l2 = l2.next;

            current = current.next;
        }

        if (l1 == null) {
            l1 = l2;
        }

        while (l1 != null) {
            current.next = new ListNode((l1.val + carry) % 10);
            carry = (l1.val + carry) / 10;

            l1 = l1.next;

            current = current.next;
        }

        if (carry != 0) {
            current.next = new ListNode((carry) % 10);
        }

        return head.next;
    }
}
