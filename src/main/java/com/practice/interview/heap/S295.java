package com.practice.interview.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class S295 {
    static class MedianFinder2 {
        static class Node {
            int value;
            Node prev;
            Node next;

            Node(int value) {
                this.value = value;
            }

            public void insertNext(int val) {
                Node node = new Node(val);
                Node temp = this.next;

                this.next = node;
                node.prev = this;

                if (temp != null) {
                    temp.prev = node;
                    node.next = temp;
                }
            }

            public void insertPrev(int val) {
                Node node = new Node(val);
                Node temp = this.prev;

                this.prev = node;
                node.next = this;

                if (temp != null) {
                    temp.next = node;
                    node.prev = temp;
                }
            }
        }

        int n;
        Node median;

        public MedianFinder2() {
            this.n = 0;
            this.median = null;
        }

        public void addNum(int num) {
            n++;

            if (this.median == null) {
                this.median = new Node(num);
            } else {
                Node curr = this.median;
                if (num >= this.median.value) {
                    while (curr.next != null && num >= curr.next.value) {
                        curr = curr.next;
                    }

                    curr.insertNext(num);

                    if (n % 2 == 1) {
                        this.median = this.median.next;
                    }
                } else {
                    while (curr.prev != null && num < curr.prev.value) {
                        curr = curr.prev;
                    }

                    curr.insertPrev(num);

                    if (n % 2 == 0) {
                        this.median = this.median.prev;
                    }
                }
            }
        }

        public double findMedian() {
            if (n % 2 == 1) {
                return this.median.value;
            }

            return (double) (this.median.value + this.median.next.value) / 2;
        }
    }

    static class MedianFinder {
        private int n;
        private Queue<Integer> lessQueue;
        private int median;
        private Queue<Integer> moreQueue;

        public MedianFinder() {
            this.n = 0;
            this.median = 0;
            this.lessQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
            this.moreQueue = new PriorityQueue<>();
        }

        public void addNum(int num) {
            n++;
            if (n == 1) {
                this.median = num;

                return;
            }

            if (num >= this.median) {
                this.moreQueue.add(num);

                if (n % 2 == 1) {
                    this.lessQueue.add(this.median);
                    this.median = this.moreQueue.poll();
                }
            } else {
                this.lessQueue.add(num);

                if (n % 2 == 0) {
                    this.moreQueue.add(this.median);
                    this.median = this.lessQueue.poll();
                }
            }
        }

        public double findMedian() {
            if (n % 2 == 1) {
                return this.median;
            }

            return (double) (this.median + this.moreQueue.peek()) / 2;
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        medianFinder.findMedian(); // return 2.0
    }
}
