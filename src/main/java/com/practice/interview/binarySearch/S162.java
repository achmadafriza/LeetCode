package com.practice.interview.binarySearch;

public class S162 {
    /* tbh, easier if i can change the array */
    public static int findPeakElement(int[] nums) {
        if (nums.length >= 2) {
            if (nums[0] > nums[1]) {
                return 0;
            }

            if (nums[nums.length - 2] < nums[nums.length - 1]) {
                return nums.length - 1;
            }
        }

        int left = 1;
        int right = nums.length - 2;

        while (left <= right) {
            int mid = left + (right - left + 1) / 2;

            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid - 1] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        findPeakElement(new int[]{1, 2, 1});
    }
}
