package com.practice.interview.interval;

import java.lang.reflect.Array;
import java.util.*;

public class S56 {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> result = new ArrayList<>();

        int[] interval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if ((intervals[i][0] <= interval[1] && interval[1] <= intervals[i][1]) || (interval[0] <= intervals[i][0] && intervals[i][0] <= interval[1])) {
                interval[0] = Math.min(interval[0], intervals[i][0]);
                interval[1] = Math.max(interval[1], intervals[i][1]);
            } else {
                result.add(interval);

                interval = intervals[i];
            }
        }

        result.add(interval);

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        merge(new int[][]{
                {1, 4},
                {0, 1}
        });
    }
}
