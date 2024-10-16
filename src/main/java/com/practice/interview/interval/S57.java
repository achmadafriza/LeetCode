package com.practice.interview.interval;

import java.util.*;

public class S57 {
    public static int binarySearch(int[][] ints, int key) {
        int left = 0;
        int right = ints.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (key <= ints[mid][0]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static int[][] insert2(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>(Arrays.asList(intervals));

        int index = binarySearch(intervals, newInterval[0]);
        result.add(index, newInterval);

        intervals = result.toArray(new int[result.size()][]);
        result = new ArrayList<>();

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

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);

            i++;
        }

        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);

            i++;
        }

        result.add(newInterval);

        while (i < intervals.length) {
            result.add(intervals[i]);

            i++;
        }

        return result.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        insert(new int[][]{
                {1,3},
                {6,9}
        }, new int[]{2,5});
    }
}
