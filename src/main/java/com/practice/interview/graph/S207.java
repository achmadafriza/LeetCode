package com.practice.interview.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class S207 {
    static class Node {
        int code;
        Set<Node> directed;

        Node(int code) {
            this.code = code;
            this.directed = new HashSet<>();
        }
    }

    public static boolean hasCycle(Node node, Set<Integer> toVisit, Set<Integer> cycleSet) {
        if (toVisit.contains(node.code)) {
            toVisit.remove(node.code);
            cycleSet.add(node.code);

            for (Node adj : node.directed) {
                if (cycleSet.contains(adj.code) || (toVisit.contains(adj.code) && hasCycle(adj, toVisit, cycleSet))) {
                    return true;
                }
            }
        }

        cycleSet.remove(node.code);

        return false;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Node> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int prereqCode = prerequisite[1];
            int canTakeCode = prerequisite[0];

            Node prereq = map.getOrDefault(prereqCode, new Node(prereqCode));
            map.put(prereqCode, prereq);

            Node canTake = map.getOrDefault(canTakeCode, new Node(canTakeCode));
            map.put(canTakeCode, canTake);

            prereq.directed.add(canTake);
        }

        Set<Integer> toVisit = map.values().stream()
                .map(node -> node.code)
                .collect(Collectors.toSet());
        for (int i = 0 ; i < numCourses; i++) {
            if (toVisit.contains(i)) {
                Set<Integer> cycleSet = new HashSet<>();
                if (hasCycle(map.get(i), toVisit, cycleSet)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        canFinish(10, new int[][]{
                {5, 5}
        });
    }
}
