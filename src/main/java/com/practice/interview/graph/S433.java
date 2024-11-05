package com.practice.interview.graph;

import java.util.*;

public class S433 {
    public static int diff(String s1, String s2) {
        int result = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                result++;
            }
        }

        return result;
    }

    public static int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        Map<String, Integer> dist = new HashMap<>();
        for (String s : bank) {
            dist.put(s, Integer.MAX_VALUE);
        }

        queue.add(startGene);
        dist.put(startGene, 0);
        dist.put(endGene, Integer.MAX_VALUE);
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            visited.add(curr);

            for (String dst : bank) {
                if (!visited.contains(dst) && diff(curr, dst) == 1) {
                    dist.put(dst, Integer.min(dist.get(dst), dist.get(curr) + 1));

                    queue.add(dst);
                }
            }
        }

        int result = dist.get(endGene);
        if (result == Integer.MAX_VALUE) {
            return -1;
        }

        return result;
    }

    public static void main(String[] args) {
        minMutation("AACCGGTT", "AAACGGTA", new String[]{
                "AACCGGTA","AACCGCTA","AAACGGTA"
        });
    }
}
