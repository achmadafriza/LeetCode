package com.practice.interview.heap;

import java.util.*;

public class S373 {
    class Sum {
        private int num1;
        private int num2;
        private int pos;

        private int sum;

        private Sum(int num1, int num2, int pos) {
            this.num1 = num1;
            this.num2 = num2;
            this.pos = pos;

            this.sum = num1 + num2;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<Sum> queue = new PriorityQueue<>(Comparator.comparing(obj -> obj.sum));
        for (int i = 0; i < nums1.length; i++) {
            queue.add(new Sum(nums1[i], nums2[0], 0));
        }

        List<List<Integer>> result = new ArrayList<>();
        while (k > 0) {
            Sum take = queue.poll();

            List<Integer> pair = new ArrayList<>();
            pair.add(take.num1);
            pair.add(take.num2);

            result.add(pair);

            if (take.pos + 1 < nums2.length) {
                Sum newSum = new Sum(take.num1, nums2[take.pos + 1], take.pos + 1);

                queue.add(newSum);
            }

            k--;
        }

        return result;
    }
}
