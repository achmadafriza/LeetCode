package com.practice.interview.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class S122 {
    public static int decision3(int[] prices, int minPrice, int i) {
        if (i >= prices.length) {
            return 0;
        }

        int sell = Math.max(prices[i] - minPrice, 0) + decision(prices, prices[i], i+1);
        int hold = decision(prices, minPrice, i+1);

        return Math.max(sell, hold);
    }

    public static int maxProfit3(int[] prices) {
        return decision3(prices, prices[0], 0);
    }

    private static int[][] dp;

    public static int decision2(int[] prices, int minPrice, int i) {
        if (i >= prices.length) {
            return dp[minPrice][prices.length-1];
        }

        if (dp[minPrice][i] != -1) {
            return dp[minPrice][i];
        }

        int sell = Math.max(prices[i] - minPrice, 0) + decision(prices, prices[i], i+1);
        int hold = decision(prices, minPrice, i+1);

        dp[minPrice][i] = Math.max(sell, hold);

        return dp[minPrice][i];
    }

    public static int maxProfit2(int[] prices) {
        dp = new int[10100][prices.length];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return decision(prices, prices[0], 0);
    }

    // Memoization map to store results of subproblems
    private static Map<String, Integer> memo;

    public static int decision(int[] prices, int minPrice, int i) {
        // Base case: if we have gone through all prices
        if (i >= prices.length) {
            return 0;
        }

        // Create a key for the memoization map
        String key = minPrice + "-" + i;

        // Check if the result for this subproblem is already computed
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Calculate the profit if we sell at the current price
        int sell = Math.max(prices[i] - minPrice, 0) + decision(prices, prices[i], i + 1);

        // Calculate the profit if we hold
        int hold = decision(prices, minPrice, i + 1);

        // Store the result in the memoization map before returning
        int result = Math.max(sell, hold);
        memo.put(key, result);

        return result;
    }

    public static int maxProfitMemo(int[] prices) {
        memo = new HashMap<>();
        return decision(prices, prices[0], 0);
    }

    public static int maxProfit(int[] prices) {
        int current = prices[0];
        int ans = 0;
        for(int price : prices) {
            if (price > current) {
                ans += price - current;
            }

            current = price;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
