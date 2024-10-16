package com.practice.interview.array;

import java.util.Arrays;

public class S45 {
    public static int jump2(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {
                dp[j] = Math.min(dp[i] + 1, dp[j]);
            }
        }

        return dp[nums.length-1];
    }

    public static int jump(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i-1], i + nums[i]);
        }

        int i = 0;
        int ans = 0;
        while (i < nums.length - 1) {
            ans++;
            i = nums[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }
}
