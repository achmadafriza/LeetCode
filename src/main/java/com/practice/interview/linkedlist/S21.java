package com.practice.interview.linkedlist;

public class S21 {
    public static class ListNode {
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

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode head;
        ListNode remaining;
        if (list1.val < list2.val) {
            head = list1;
            remaining = list2;
        } else {
            head = list2;
            remaining = list1;
        }

        ListNode prev = head;
        ListNode current = head.next;
        while (remaining != null && current != null) {
            if (remaining.val <= current.val) {
                prev.next = remaining;
                remaining = remaining.next;
                prev.next.next = current;

                current = prev.next;
            }

            prev = current;
            current = current.next;
        }

        if (remaining != null) {
            prev.next = remaining;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        mergeTwoLists(list1, list2);
    }
}
