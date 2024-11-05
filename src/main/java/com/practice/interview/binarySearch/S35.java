package com.practice.interview.binarySearch;

public class S35 {
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        if (target > nums[right]) {
            return right + 1;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        searchInsert(new int[]{1, 3, 5, 6}, 7);
    }
}
