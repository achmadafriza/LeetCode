package com.practice.interview.interval;

import java.util.ArrayList;
import java.util.List;

public class S228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }

        int low = nums[0];
        int high = nums[0] + 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == high) {
                high++;
            } else if (low + 1 == high) {
                result.add(String.format("%d", low));

                low = nums[i];
                high = nums[i] + 1;
            } else {
                result.add(String.format("%d->%d", low, high - 1));

                low = nums[i];
                high = nums[i] + 1;
            }
        }

        if (low + 1 == high) {
            result.add(String.format("%d", low));
        } else {
            result.add(String.format("%d->%d", low, high - 1));
        }

        return result;
    }
}
