package com.practice.interview.backtrack;

import java.util.*;

public class S39 {
    public void trySum2(Set<List<Integer>> result, List<Integer> curr, int sum, int[] candidate, int target) {
        if (sum == target) {
            List<Integer> list = new ArrayList<>(curr);
            Collections.sort(list);

            result.add(list);
            return;
        }

        if (sum > target) {
            return;
        }

        for (int num : candidate) {
            curr.add(num);
            trySum2(result, curr, sum + num, candidate, target);
            curr.removeLast();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>();

        trySum2(result, new ArrayList<>(), 0, candidates, target);

        return new ArrayList<>(result);
    }

    public void trySum(List<List<Integer>> result, List<Integer> curr, int sum, int[] candidate, int idx, int target) {
        if (sum == target) {
            List<Integer> list = new ArrayList<>(curr);
            result.add(list);

            return;
        }

        if (idx >= candidate.length) {
            return;
        }

        if (sum > target) {
            return;
        }

        int temp = sum;
        while (temp <= target) {
            temp += candidate[idx];
            curr.add(candidate[idx]);
        }

        while (temp > sum) {
            temp -= candidate[idx];
            curr.removeLast();

            trySum(result, curr, temp, candidate, idx + 1, target);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        trySum(result, new ArrayList<>(), 0, candidates, 0, target);

        return result;
    }
}

