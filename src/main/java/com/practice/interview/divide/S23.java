package com.practice.interview.divide;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class S23 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(l -> l.val));
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        ListNode result = new ListNode();
        ListNode curr = result;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();

            curr.next = node;~
            curr = curr.next;

            if (node.next != null) {
                queue.add(node.next);
            }
        }

        return result.next;
    }
}
