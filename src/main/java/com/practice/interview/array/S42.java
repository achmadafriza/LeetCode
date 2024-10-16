package com.practice.interview.array;

public class S42 {
    public static int trap(int[] height) {
        int left = 0;
        int right = 0;

        int ans = 0;
        int maxHeight = 0;
        while (left < height.length && right < height.length) {
            int wallHeight = Math.min(height[left], height[right]);
            if (height[left] <= height[right] && wallHeight != 0) {
                while (left < right) {
                    ans += wallHeight - height[left];
                    height[left] = wallHeight;
                    left++;
                }
            }

            if (height[right] > maxHeight) {
                left = right;
                maxHeight = height[right];
            }

            right++;
        }

        left = height.length - 1;
        right = height.length - 1;
        maxHeight = 0;
        while (left >= 0 && right >= 0) {
            int wallHeight = Math.min(height[left], height[right]);
            if (height[left] >= height[right] && wallHeight != 0) {
                while (left < right) {
                    ans += wallHeight - height[right];
                    height[right] = wallHeight;
                    right--;
                }
            }

            if (height[left] > maxHeight) {
                right = left;
                maxHeight = height[left];
            }

            left--;
        }

        return ans;
    }

    public static void main(String[] args) {
        trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
}
