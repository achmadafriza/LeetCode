package com.practice.interview.backtrack;

import java.util.*;

public class S77 {
    public static void recurse(List<List<Integer>> result, int[] data, int i, int[] arr, int j, int k) {
        if (i == k) {
            List<Integer> combination = new ArrayList<>();
            for (int l = 0; l < k; l++) {
                combination.add(data[l]);
            }

            result.add(combination);

            return;
        }

        if (j >= arr.length) {
            return;
        }

        /* take */
        data[i] = arr[j];
        recurse(result, data, i + 1, arr, j + 1, k);

        /* don't take */
        recurse(result, data, i, arr, j + 1, k);
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        int[] arr = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }

        recurse(result, new int[k], 0, arr, 0, k);

        return result;
    }

    public static void main(String[] args) {
        combine(4, 2);
    }
}
