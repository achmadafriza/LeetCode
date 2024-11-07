package com.practice.interview.dp;

import java.util.Arrays;

public class S198 {
    public int tryRob(int[] dp, int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        dp[i] = Integer.max(nums[i] + tryRob(dp, nums, i + 2), tryRob(dp, nums, i + 1));

        return dp[i];
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return tryRob(dp, nums, 0);
    }
}
