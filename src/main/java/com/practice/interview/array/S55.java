package com.practice.interview.array;

public class S55 {
    public boolean canJump(int[] nums) {
        int start = 0;
        int end = 0;
        while (start <= end) {
            end = Math.min(Math.max(end, start + nums[start]), nums.length - 1);
            start++;
        }

        return end == nums.length - 1;
    }
}
