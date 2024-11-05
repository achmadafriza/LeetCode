package com.practice.interview.binarySearch;

public class S33 {
    public static int findPivot2(int[] nums) {
        if (nums.length >= 2) {
            if (nums[0] > nums[1]) {
                return 0;
            }
        }

        int left = 1;
        int right = nums.length - 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            if (nums[left] > nums[right]) {
                right = mid - 1;
            } else {
                left = mid + 1;
                right = nums.length - 2;
            }
        }

        return -1;
    }

    public static int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static int search2(int[] nums, int target) {
        int min = findMin(nums);

        int result = binarySearch(nums, target, 0, min - 1);
        if (result == -1) {
            result = binarySearch(nums, target, min, nums.length - 1);
        }

        return result;
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            /* left side is sorted */
            /* <= -> left == mid, then partition = [ mid ] [ mid + 1, ... ] */
            /* if <, then can't catch that */
            if (nums[left] <= nums[mid]) {
                /* target is inside range */
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { /* right side is sorted */
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static int search3(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        search(new int[]{2, 3, 1}, 1);
    }
}
