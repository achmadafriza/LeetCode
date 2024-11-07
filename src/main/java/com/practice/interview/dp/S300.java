package com.practice.interview.dp;

import java.util.ArrayList;
import java.util.List;

public class S300 {
    public int tryLIS(int[][] dp, int[] nums, int i, int lastIndex) {
        if (i >= nums.length) {
            return 0;
        }

        if (dp[i][lastIndex + 1] != 0) {
            return dp[i][lastIndex + 1];
        }

        if (lastIndex == -1 || nums[lastIndex] < nums[i]) {
            dp[i][lastIndex + 1] = Integer.max(1 + tryLIS(dp, nums, i + 1, i), tryLIS(dp, nums, i + 1, lastIndex));
        } else {
            dp[i][lastIndex + 1] = tryLIS(dp, nums, i + 1, lastIndex);
        }

        return dp[i][lastIndex + 1];
    }

    public int lengthOfLIS2(int[] nums) {
        return tryLIS(new int[nums.length][nums.length + 1], nums, 0, -1);
    }

    public static int lowerBound(List<Integer> result, int target) {
        int left = 0;
        int right = result.size() - 1;

        while (left < right) {
            int mid = left + (right - left - 1) / 2;

            if (target <= result.get(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static int lengthOfLIS(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            if (result.isEmpty() || result.getLast() < num) {
                result.add(num);
            } else {
                int idx = lowerBound(result, num);

                result.set(idx, num);
            }
        }

        return result.size();
    }

    public static void main(String[] args) {
        lengthOfLIS(new int[]{0,1,0,3,2,3});
    }
}
