package com.practice.interview.twopointers;

public class S11 {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;

        int max = -1;
        while (i < j) {
            int minHeight = Math.min(height[i], height[j]);
            max = Math.max(max, minHeight * (j - i));

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return max;
    }
}
