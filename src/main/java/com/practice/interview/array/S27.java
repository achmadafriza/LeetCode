package com.practice.interview.array;

public class S27 {
    public static void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int last = 0;
        while (i < nums.length) {
            if (nums[i] == val) {
                i++;
            } else if (i > 0 && i > last) {
                swap(nums, i, i - 1);
                i--;
            } else {
                last = i + 1;
                i++;
            }
        }

        return last;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,2,3,0,4,2};

        removeElement(arr, 2);

        for(int i : arr) {
            System.out.println(i);
        }
    }
}
