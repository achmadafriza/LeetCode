package com.practice.interview.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class S92 {
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

    public static ListNode reverse(List<Integer> values, ListNode head, int left, int right) {
        if (left == 1 && right == 1) {
            values.add(head.val);

            head.val = values.removeFirst();

            return head;
        }

        if (left > 1) {
            reverse(values, head.next, left - 1, right - 1);
        } else {
            values.add(head.val);

            reverse(values, head.next, left, right - 1);

            head.val = values.removeFirst();
        }

        return head;
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        return reverse(new ArrayList<>(), head, left, right);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        reverseBetween(head, 2, 4);
    }
}
