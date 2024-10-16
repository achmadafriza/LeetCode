package com.practice.interview.array;

public class S80 {
    public static void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }

        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public static int removeDuplicates(int[] nums) {
        int ans = nums.length;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[j] && i - j >= 2) {
                nums[i] = Integer.MIN_VALUE;
                ans--;
            } else if (nums[i] != nums[j]) {
                j = i;
            }
        }

        j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == Integer.MIN_VALUE && nums[j] != Integer.MIN_VALUE) {
                j = i;
            } else if (nums[i] != Integer.MIN_VALUE && nums[j] == Integer.MIN_VALUE) {
                swap(nums, i, j);
                j++;
                i = j;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};

        removeDuplicates(nums);
    }
}
