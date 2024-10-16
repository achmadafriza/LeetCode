package com.practice.interview.linkedlist;

public class S82 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        head = new ListNode(110, head);

        ListNode curr = head;
        ListNode prev = head;
        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) {
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }

                prev.next = curr.next;
                curr.next = null;
                curr = prev;
            }

            prev = curr;
            curr = curr.next;
        }

        return head.next;
    }

    public static void main(String[] args) {
//        deleteDuplicates(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5))))))));
        deleteDuplicates(new ListNode(1, new ListNode(1)));
    }
}
