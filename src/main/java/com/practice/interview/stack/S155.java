package com.practice.interview.stack;

public class S155 {
    class MinStack {
        private class Node<T> {
            T data;
            Node<T> next;
            Integer min;

            Node(T data, Node<T> next) {
                this.data = data;
                this.next = next;
            }
        }

        private Node<Integer> head;
        private int min;

        public MinStack() {
            this.min = Integer.MAX_VALUE;
            this.head = null;
        }

        public void push(int val) {
            this.head = new Node<>(val, this.head);

            this.min = Math.min(this.min, val);
            this.head.min = min;
        }

        public void pop() {
            Node<Integer> temp = this.head;

            this.head = this.head.next;
            temp.next = null;

            if (this.head == null) {
                this.min = Integer.MAX_VALUE;
            } else {
                this.min = this.head.min;
            }
        }

        public int top() {
            return this.head.data;
        }

        public int getMin() {
            return this.min;
        }
    }
}
