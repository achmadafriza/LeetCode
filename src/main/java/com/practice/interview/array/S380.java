package com.practice.interview.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class S380 {
    static class RandomizedSet {
        private class Node<T> {
            T value;
            Node<T> next;

            Node(T value) {
                this.value = value;
            }
        }

        private int size;
        private int capacity;
        private static final float LOAD_FACTOR = 0.75f;

        private Node<Integer>[] table;

        public RandomizedSet() {
            this.size = 0;
            this.capacity = 16;
            this.table = (Node<Integer>[]) new Node[this.capacity];
        }

        public void resize() {
            int newCapacity = this.capacity * 2;
            Node<Integer>[] newTable = new Node[newCapacity];

            for (int i = 0; i < capacity; i++) {
                Node<Integer> current = table[i];
                while (current != null) {
                    Node<Integer> next = current.next;

                    int newIndex = ((current.value.hashCode() % newCapacity) + newCapacity) % newCapacity;
                    current.next = newTable[newIndex];
                    newTable[newIndex] = current;

                    current = next;
                }
            }

            this.table = newTable;
            this.capacity = newCapacity;
        }

        public boolean insert(int val) {
            if (this.size++ == this.capacity * LOAD_FACTOR) {
                resize();
            }

            int index = ((val % capacity) + capacity) % capacity;

            Node<Integer> previous = null;
            Node<Integer> current = this.table[index];
            while (current != null) {
                if (current.value.equals(val)) {
                    return false;
                }

                previous = current;
                current = current.next;
            }

            if (previous != null) {
                previous.next = new Node<>(val);
            } else {
                this.table[index] = new Node<>(val);
            }

            return true;
        }

        public boolean remove(int val) {
            int index = ((val % capacity) + capacity) % capacity;
            boolean isPresent = false;

            Node<Integer> previous = null;
            Node<Integer> current = this.table[index];
            while (current != null) {
                if (current.value.equals(val)) {
                    isPresent = true;
                    if (previous == null) {
                        table[index] = current.next;
                    } else {
                        previous.next = current.next;
                        current.next = null;
                    }
                }

                previous = current;
                current = current.next;
            }

            this.size--;

            return isPresent;
        }

        public int getRandom() {
            Random generator = new Random();
            int index = ((generator.nextInt() % capacity) + capacity) % capacity;

            List<Integer> list = new ArrayList<>();

            Node<Integer> current = this.table[index];
            while (current == null) {
                index = ((generator.nextInt() % capacity) + capacity) % capacity;
                current = this.table[index];
            }

            while (current != null) {
                list.add(current.value);

                current = current.next;
            }

            return list.get(generator.nextInt(list.size()));
        }
    }

    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        set.insert(0);
        set.insert(1);
        set.insert(2);
        set.insert(3);
        set.insert(4);
        set.remove(0);
        set.remove(1);
        set.getRandom();
    }
}
