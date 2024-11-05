package com.practice.interview.backtrack;

import java.util.ArrayList;
import java.util.List;

public class S46 {
    public void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }

        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public void recurse(List<List<Integer>> result, int[] nums, int idx) {
        if (idx >= nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }

            result.add(list);

            return;
        }

        for (int i = idx; i < nums.length; i++) {
            swap(nums, i, idx);

            recurse(result, nums, idx + 1);

            swap(nums, i, idx);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        recurse(result, nums, 0);

        return result;
    }
}
