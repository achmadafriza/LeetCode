package com.tiktok;

import java.util.*;

public class S4 {
    public static int stockPairs(List<Integer> stocksProfit, long target) {
        Map<Integer, Integer> profitCount = new HashMap<>();
        for (int profit : stocksProfit) {
            profitCount.put(profit, profitCount.getOrDefault(profit, 0) + 1);
        }

        Set<Set<Integer>> result = new HashSet<>();
        for (int profit : stocksProfit) {
            int tempTarget = (int) (target - profit);
            if (profitCount.getOrDefault(profit, 0) > 0) {
                profitCount.put(profit, profitCount.get(profit) - 1);
                if (profitCount.getOrDefault(tempTarget, 0) > 0) {
                    profitCount.put(tempTarget, profitCount.get(tempTarget) - 1);

                    Set<Integer> pair = new HashSet<>();
                    pair.add(profit);
                    pair.add(tempTarget);

                    result.add(pair);
                } else {
                    profitCount.put(profit, profitCount.get(profit) + 1);
                }
            }
        }

        return result.size();
    }

    public static void main(String[] args) {
        stockPairs(Arrays.asList(1, 3, 46, 1, 3, 9), 47);
    }
}
