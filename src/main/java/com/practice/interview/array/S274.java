package com.practice.interview.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class S274 {
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);

        int ans = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] >= ans + 1) {
                ans++;
            } else {
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{1}));
    }
}
