package com.practice.interview.array;

import java.util.Arrays;

public class S88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        while (n > 0) {
            if (m > 0 && nums1[m-1] > nums2[n-1]) {
                nums1[i] = nums1[m-1];
                m--;
            } else {
                nums1[i] = nums2[n-1];
                n--;
            }

            i--;
        }

        for(int num : nums1) {
            System.out.println(num);
        }
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] arr1 = Arrays.copyOf(nums1, m);
        int i = 0;
        int j = 0;
        for (int k = 0; k < m + n; k++) {
            if (i == m || arr1[i] >= nums2[j]) {
                nums1[k] = nums2[j];
                j++;
            } else if (j == n || arr1[i] < nums2[j]) {
                nums1[k] = arr1[i];
                i++;
            }
        }

        for(int num : nums1) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};

        merge(nums1, 3, nums2, 3);
    }
}
