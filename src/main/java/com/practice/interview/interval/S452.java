package com.practice.interview.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class S452 {
    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));

        List<int[]> result = new ArrayList<>();

        int[] interval = points[0];
        for (int i = 1; i < points.length; i++) {
            if ((points[i][0] <= interval[1] && interval[1] <= points[i][1]) || (interval[0] <= points[i][0] && points[i][0] <= interval[1])) {
                interval[0] = Math.max(interval[0], points[i][0]);
                interval[1] = Math.min(interval[1], points[i][1]);
            } else {
                result.add(interval);

                interval = points[i];
            }
        }

        result.add(interval);

        return result.size();
    }
}
