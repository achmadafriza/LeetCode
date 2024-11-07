package com.practice.interview.dp;

import java.util.Arrays;

public class S322 {
    public static int tryCoinChange(int[] dp, int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }

        if (dp[amount] != -1) {
            return dp[amount];
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int temp = tryCoinChange(dp, coins, amount - coin);
            if (temp != -1) {
                min = Integer.min(min, 1 + temp);
            }
        }

        if (min == Integer.MAX_VALUE) {
            return -1;
        }

        dp[amount] = min;

        return min;
    }

    public static int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);

        return tryCoinChange(dp, coins, amount);
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i <= amount; i++) {
            if (dp[i] != Integer.MAX_VALUE) {
                for (int coin : coins) {
                    if (0 <= i + coin && i + coin <= amount) {
                        dp[i + coin] = Integer.min(dp[i + coin], dp[i] + 1);
                    }
                }
            }
        }

        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        coinChange(new int[]{1,2,5}, 100);
    }
}
