package com.practice.interview.array;

import java.util.Arrays;

public class S189 {
    public static void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }

        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public static void rotateRight(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, i-1, i);
        }
    }

    public void rotate4(int[] nums, int k) {
        k = k % nums.length;
        for(int i = 0; i < k; i++) {
            rotateRight(nums);
        }
    }

    public static void rotate3(int[] nums, int k) {
        int i = 0;
        int current = nums[i];
        for (int n = 0; n < nums.length; n++) {
            int newIndex = (i + k) % nums.length;

            int temp = nums[newIndex];
            nums[newIndex] = current;
            current = temp;

            i = newIndex;
            if (k % 2 == 0 && n % 2 == 1) {
                i++;
                current = nums[newIndex];
            }
        }

        for(int num : nums) {
            System.out.printf("%d ", num);
        }
    }

    public static void rotate2(int[] nums, int k) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < nums.length; i++) {
            nums[(i + k) % nums.length] = arr[i];
        }
    }

    public static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void main(String[] args) {
        rotate(new int[]{1, 2}, 2);
    }
}
