package com.practice.interview.binarySearch;

public class S34 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int low = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target <= nums[mid]) {
                low = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (low == -1) {
            return new int[] {-1, -1};
        }

        left = low;
        right = nums.length - 1;

        int high = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= target) {
                high = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (high == -1) {
            return new int[] {-1, -1};
        }

        return new int[]{low, high};
    }
}
