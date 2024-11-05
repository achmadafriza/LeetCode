package com.practice.interview.binarySearch;

public class S74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;

        int[] result = matrix[0];
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (matrix[mid][0] <= target) {
                left = mid + 1;
                result = matrix[mid];
            } else {
                right = right - 1;
            }
        }

        left = 0;
        right = result.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (result[mid] == target) {
                return true;
            } else if (result[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
