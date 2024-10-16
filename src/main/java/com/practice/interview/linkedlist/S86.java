package com.practice.interview.linkedlist;

public class S86 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode partition(ListNode head, int x) {
        head = new ListNode(110, head);

        ListNode partition = new ListNode(110, head);
        ListNode partitionCurr = partition;

        ListNode prev = head;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                partitionCurr.next = curr;
                partitionCurr = partitionCurr.next;

                prev.next = curr.next;
                curr.next = null;

                curr = prev;
            }

            prev = curr;
            curr = curr.next;
        }

        partitionCurr.next = head.next;

        return partition.next;
    }
}
