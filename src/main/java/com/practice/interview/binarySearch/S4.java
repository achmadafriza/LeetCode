package com.practice.interview.binarySearch;

import java.util.Map;

public class S4 {
    public static int findKthSmallest(int[] nums1, int[] nums2, int k) {
        int left1 = 0, right1 = nums1.length - 1;
        int left2 = 0, right2 = nums2.length - 1;

        while (left1 <= right1 && left2 <= right2) {
            int mid1 = left1 + (right1 - left1) / 2;
            int mid2 = left2 + (right2 - left2) / 2;

            if (k > mid1 + mid2) {
                if (nums1[mid1] <= nums2[mid2]) {
                    left1 = mid1 + 1;
                } else {
                    left2 = mid2 + 1;
                }
            } else {
                if (nums1[mid1] >= nums2[mid2]) {
                    right1 = mid1 - 1;
                } else {
                    right2 = mid2 - 1;
                }
            }
        }

        if (left1 > right1) {
            return nums2[k - left1];
        }

        return nums1[k - left2];
    }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int n = n1 + n2;

        if ((n1 + n2) % 2 == 1) {
            return findKthSmallest(nums1, nums2, n / 2);
        } else {
            return (double) (findKthSmallest(nums1, nums2, n / 2) + findKthSmallest(nums1, nums2, n / 2 - 1)) / 2;
        }
    }


    /* self-balancing binary search based on smaller partition on [..., maxLeftA, maxLeftB] -> |n / 2| */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n = n1 + n2;

        int left = 0;
        int right = n1;
        while (left <= right) {
            int mid1 = left + (right - left) / 2;
            int mid2 = (n + 1) / 2 - mid1;

            int maxLeftA = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int minRightA = mid1 == n1 ? Integer.MAX_VALUE : nums1[mid1];
            int maxLeftB = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int minRightB = mid2 == n2 ? Integer.MAX_VALUE : nums2[mid2];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                /* calculate median */
                if (n % 2 == 1) {
                    return Math.max(maxLeftA, maxLeftB);
                }

                return (double) (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2;
            } else if (maxLeftA > minRightB) {
                right = mid1 - 1;
            } else {
                left = mid1 + 1;
            }
        }

        return 0.0;
    }

    public static void main(String[] args) {
        findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
    }
}
