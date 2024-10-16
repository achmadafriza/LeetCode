package com.practice.interview.slidingwindow;

public class S209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;

        while (target > 0 && right < nums.length) {
            target -= nums[right];
            right++;
        }

        int min = Integer.MAX_VALUE;
        if (target <= 0) {
            min = right - left;
        }

        while (right < nums.length) {
            while (left < nums.length && target <= 0) {
                target += nums[left];
                left++;

                if (target <= 0) {
                    min = Math.min(min, right - left);
                }
            }

            target -= nums[right];
            right++;

            if (target <= 0) {
                min = Math.min(min, right - left);
            }
        }

        while (left < nums.length && target <= 0) {
            target += nums[left];
            left++;

            if (target <= 0) {
                min = Math.min(min, right - left);
            }
        }

        if (min == Integer.MAX_VALUE) {
            return 0;
        }

        return min;
    }

    public static void main(String[] args) {
        minSubArrayLen(15, new int[]{5,1,3,5,10,7,4,9,2,8});
    }
}
