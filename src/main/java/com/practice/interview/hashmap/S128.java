package com.practice.interview.hashmap;

import java.util.*;

public class S128 {
    public static int longestConsecutive2(int[] nums) {
        Map<Integer, Deque<Integer>> sequenceMap = new HashMap<>();

        int max = 0;
        for (int num : nums) {
            int left = num - 1;
            int right = num + 1;

            if (sequenceMap.containsKey(num)) {
                continue;
            }

            Deque<Integer> deque = null;
            if (sequenceMap.containsKey(left)) {
                deque = sequenceMap.remove(left);

                if (deque.contains(num)) {
                    sequenceMap.put(left, deque);

                    deque = null;
                } else {
                    deque.addLast(num);

                    sequenceMap.remove(deque.peekLast());
                }
            }

            if (deque == null) {
                deque = new LinkedList<>();
                deque.addLast(num);
            }

            if (sequenceMap.containsKey(right)) {
                Deque<Integer> rightDeque = sequenceMap.remove(right);

                if (rightDeque.contains(num)) {
                    sequenceMap.put(right, rightDeque);

                    deque = null;
                } else {
                    sequenceMap.remove(deque.peekFirst());

                    while (!deque.isEmpty()) {
                        rightDeque.addFirst(deque.removeLast());
                    }

                    deque = rightDeque;
                }
            }

            if (deque != null) {
                max = Math.max(max, deque.size());

                if (!sequenceMap.containsKey(deque.peekFirst())) {
                    sequenceMap.put(deque.peekFirst(), deque);
                }

                if (!sequenceMap.containsKey(deque.peekLast())) {
                    sequenceMap.put(deque.peekLast(), deque);
                }
            }
        }

        return max;
    }

    public static int longestConsecutive(int[] nums) {
        Map<Integer, Deque<Integer>> sequenceMap = new HashMap<>();

        int max = 0;
        for (int num : nums) {
            int left = num - 1;
            int right = num + 1;

            if (sequenceMap.containsKey(num)) {
                continue;
            }

            Deque<Integer> deque = null;
            if (sequenceMap.containsKey(left)) {
                Deque<Integer> leftDeque = sequenceMap.get(left);
                if (num < leftDeque.peekFirst() || leftDeque.peekLast() < num) {
                    sequenceMap.remove(leftDeque.peekFirst());
                    sequenceMap.remove(leftDeque.peekLast());

                    if (leftDeque.size() == 2) {
                        leftDeque.removeLast();
                    }

                    leftDeque.addLast(num);

                    deque = leftDeque;
                    num = leftDeque.peekFirst();
                }
            }

            if (deque == null) {
                deque = new LinkedList<>();
                deque.addLast(num);
            }

            if (sequenceMap.containsKey(right)) {
                Deque<Integer> rightDeque = sequenceMap.get(right);

                if (num < rightDeque.peekFirst() || rightDeque.peekLast() < num) {
                    sequenceMap.remove(rightDeque.peekFirst());
                    sequenceMap.remove(rightDeque.peekLast());

                    if (rightDeque.size() == 2) {
                        rightDeque.removeFirst();
                    }

                    rightDeque.addFirst(num);

                    deque = rightDeque;
                }
            }

            max = Math.max(max, deque.peekLast() - deque.peekFirst() + 1);

            if (!sequenceMap.containsKey(deque.peekFirst())) {
                sequenceMap.put(deque.peekFirst(), deque);
            }

            if (!sequenceMap.containsKey(deque.peekLast())) {
                sequenceMap.put(deque.peekLast(), deque);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        longestConsecutive(new int[]{4,1,3,2});
    }
}
