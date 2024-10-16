package com.practice.interview.array;

public class S26 {
    public static void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }

        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[i] >= nums[j]) {
                j++;
            } else {
                swap(nums, i + 1, j);
                i++;
                j = i;
            }
        }

        return i+1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};

        removeDuplicates(nums);
    }
}
