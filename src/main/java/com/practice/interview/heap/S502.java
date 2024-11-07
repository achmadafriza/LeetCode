package com.practice.interview.heap;

import java.util.*;

public class S502 {
    static class Project {
        private int profit;
        private int capital;

        Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Queue<Project> profitQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.profit, o1.profit));
        Queue<Project> capitalQueue = new PriorityQueue<>(Comparator.comparing(project -> project.capital));

        for (int i = 0; i < profits.length; i++) {
            Project project = new Project(profits[i], capital[i]);

            capitalQueue.add(project);
        }

        while (k > 0) {
            while (!capitalQueue.isEmpty() && w >= capitalQueue.peek().capital) {
                profitQueue.add(capitalQueue.poll());
            }

            Project take = profitQueue.poll();
            if (take != null) {
                w += take.profit;
            }

            k--;
        }

        return w;
    }

    public static void main(String[] args) {
        findMaximizedCapital(1, 2, new int[]{1,2,3}, new int[]{1,1,2});
    }
}
