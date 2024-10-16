package com.practice.interview.divide;

public class S148 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode prev = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode partition = prev.next;
        prev.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(partition);

        ListNode result = new ListNode();
        ListNode curr = result;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }

            curr = curr.next;
        }

        while (left != null) {
            curr.next = left;
            left = left.next;
            curr = curr.next;
        }

        while (right != null) {
            curr.next = right;
            right = right.next;
            curr = curr.next;
        }

        return result.next;
    }
    
    public static ListNode sortList2(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode left = new ListNode();
        ListNode pivot = head;
        ListNode right = new ListNode();

        ListNode curr = pivot.next;
        pivot.next = null;

        ListNode leftCurr = left;
        ListNode rightCurr = right;
        while (curr != null) {
            if (curr.val <= pivot.val) {
                leftCurr.next = curr;
                leftCurr = leftCurr.next;
            } else {
                rightCurr.next = curr;
                rightCurr = rightCurr.next;
            }

            curr = curr.next;
        }

        rightCurr.next = null;
        leftCurr.next = null;

        ListNode result = sortList2(left.next);
        curr = result;
        while (curr != null && curr.next != null) {
            curr = curr.next;
        }

        if (curr == null) {
            result = pivot;
            pivot.next = sortList2(right.next);
        } else {
            curr.next = pivot;
            pivot.next = sortList2(right.next);
        }

        return result;
    }

    public static void main(String[] args) {
        sortList(new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3)))));
        System.out.println("done");
    }
}
