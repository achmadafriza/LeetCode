package com.practice.interview.heap;

import java.util.PriorityQueue;
import java.util.Random;

public class S215 {
    private static Random random = new Random();

    public static void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }

        assert 0 <= i && i < nums.length && 0 <= j && j < nums.length;

        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public static int quickSearch(int[] nums, int k, int left, int right) {
        if (k == 0) {
            return nums[left];
        }

        int pivotIndex = random.nextInt(left, right + 1);
        swap(nums, right, pivotIndex);

        int pivot = nums[right];

        int j = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, j);

                j++;
            }
        }

        swap(nums, j, right);

        int numMin = j - left + 1;
        if (numMin < k) {
            return quickSearch(nums, k - numMin, j + 1, right);
        } else if (numMin == k) {
            return pivot;
        } else {
            return quickSearch(nums, k, left, j - 1);
        }
    }

    public static int findKthLargest2(int[] nums, int k) {
        return quickSearch(nums, nums.length - k + 1, 0, nums.length - 1);
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));

        for (int num : nums) {
            queue.add(num);
        }

        while (k > 1) {
            queue.poll();
            k--;
        }

        return queue.peek();
    }

    public static void main(String[] args) {
        findKthLargest(new int[]{3,2,1,5,6,4}, 2);
    }
}
