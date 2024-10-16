package com.practice.interview.hashmap;

import java.util.HashSet;
import java.util.Set;

public class S219 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> values = new HashSet<>();
        for (int i = 0; i <= k && i < nums.length; i++) {
            if (values.contains(nums[i])) {
                return true;
            }

            values.add(nums[i]);
        }

        for (int i = k + 1; i < nums.length; i++) {
            values.remove(nums[i - (k + 1)]);

            if (values.contains(nums[i])) {
                return true;
            }

            values.add(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2);
    }
}
