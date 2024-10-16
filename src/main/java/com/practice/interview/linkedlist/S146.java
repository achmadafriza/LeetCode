package com.practice.interview.linkedlist;

import java.util.Hashtable;

public class S146 {
    /**
     * TODO: change to doubly-linked list for LRU
     */
    static class LRUCache {
        private class Node<T, U> {
            T key;
            U val;

            int rank;
            Node<T, U> next;
        }

        private int size;
        private final int capacity;
        private Node<Integer, Integer>[] hashmap;

        private Node<Integer, Integer>[] usedMap;
        private int recentRank;

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            this.hashmap = new Node[this.capacity];

            this.usedMap = new Node[this.capacity];
            this.recentRank = 0;
        }

        public int get(int key) {
            int hash = hash(key);

            Node<Integer, Integer> curr = hashmap[hash];
            while (curr != null && key != curr.key) {
                curr = curr.next;
            }

            if (curr == null) {
                return -1;
            }

            curr.rank = ++recentRank;

            return curr.val;
        }

        public void put(int key, int value) {
            int hash = hash(key);

            Node<Integer, Integer> curr = hashmap[hash];
            while (curr != null && curr.key != key && curr.next != null) {
                curr = curr.next;
            }

            if (curr != null && curr.key == key) {
                curr.val = value;
                curr.rank = ++recentRank;

                return;
            }

            int minIndex = -1;
            if (size + 1 > capacity) {
                minIndex = evict();
            }

            curr = hashmap[hash];
            while (curr != null && curr.next != null) {
                curr = curr.next;
            }

            Node<Integer, Integer> newNode = new Node<>();
            if (curr == null) {
                hashmap[hash] = newNode;
            } else {
                curr.next = newNode;
            }

            newNode.key = key;
            newNode.val = value;
            newNode.rank = ++recentRank;

            if (minIndex == -1) {
                minIndex = this.size;
            }

            usedMap[minIndex] = newNode;

            this.size++;
        }

        private int evict() {
            int minRank = Integer.MAX_VALUE;
            Node<Integer, Integer> minNode = null;
            int minIndex = -1;
            for (int i = 0; i < size; i++) {
                Node<Integer, Integer> node = usedMap[i];
                if (node != null && node.rank < minRank) {
                    minRank = node.rank;
                    minNode = node;
                    minIndex = i;
                }
            }

            int hash = hash(minNode.key);

            Node<Integer, Integer> prev = hashmap[hash];
            Node<Integer, Integer> curr = prev;
            while (curr != minNode) {
                prev = curr;
                curr = curr.next;
            }

            if (prev == curr) {
                hashmap[hash] = curr.next;
            } else {
                prev.next = curr.next;
                curr.next = null;
            }

            this.size--;

            return minIndex;
        }

        private int hash(int key) {
            return (key * 101) % capacity;
        }
    }

    public static void main(String[] args) {
//        LRUCache lRUCache = new LRUCache(2);
//        lRUCache.get(2);
//        lRUCache.put(2, 6);
//        lRUCache.get(1);
//        lRUCache.put(1, 5);
//        lRUCache.put(1, 2);
//        lRUCache.get(1);
//        lRUCache.get(2);

        LRUCache lRUCache = new LRUCache(1);
        lRUCache.put(2, 1);
        lRUCache.get(2);
        lRUCache.put(3, 2);
        lRUCache.get(2);
        lRUCache.get(3);
    }
}
