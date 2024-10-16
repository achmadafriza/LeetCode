package com.practice.interview.array;

import java.util.HashMap;
import java.util.Map;

public class S169 {
    public int majorityElement(int[] nums) {
        int n = (nums.length / 2) + 1;
        Map<Integer, Integer> elements = new HashMap<>();

        for(int num : nums) {
            int count = elements.getOrDefault(num, 0) + 1;
            elements.put(num, count);

            if (count == n) {
                return num;
            }
        }

        throw new IllegalStateException();
    }
}
