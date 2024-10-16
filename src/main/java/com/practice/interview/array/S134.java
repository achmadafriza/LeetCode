package com.practice.interview.array;

public class S134 {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int current = 0;
        int start = -1;
        for (int i = 0; i < gas.length; i++) {
            int journeyCost = gas[i] - cost[i];
            if (current + journeyCost < 0) {
                if (journeyCost < 0) {
                    current = 0;
                    start = -1;
                } else {
                    current = journeyCost;
                    start = i;
                }
            } else {
                if (start == -1) {
                    start = i;
                }

                current += journeyCost;
            }
        }

        for (int i = 0; i < start; i++) {
            int journeyCost = gas[i] - cost[i];

            current += journeyCost;
            if (current < 0) {
                return -1;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        canCompleteCircuit(new int[]{3,1,1}, new int[]{1,2,2});
    }
}
