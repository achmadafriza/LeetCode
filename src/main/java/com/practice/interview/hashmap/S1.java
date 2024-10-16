package com.practice.interview.hashmap;

import java.util.HashMap;
import java.util.Map;

public class S1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int find = target - nums[i];
            if (numIndex.containsKey(find)) {
                return new int[]{i, numIndex.get(find)};
            }

            numIndex.put(nums[i], i);
        }

        throw new IllegalStateException();
    }
}
