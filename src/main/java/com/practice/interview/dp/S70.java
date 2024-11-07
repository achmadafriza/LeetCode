package com.practice.interview.dp;

public class S70 {
    public int climbStairs2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public int climbStairs(int n) {
        int prev2 = 0;
        int prev1 = 1;
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = prev1 + prev2;

            prev2 = prev1;
            prev1 = result;
        }

        return result;
    }
}
