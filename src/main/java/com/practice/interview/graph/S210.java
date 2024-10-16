package com.practice.interview.graph;

import com.sun.source.tree.WhileLoopTree;

import java.util.*;
import java.util.stream.Collectors;

public class S210 {
    static class Node {
        int code;
        Set<Node> directed;

        Node(int code) {
            this.code = code;
            this.directed = new HashSet<>();
        }
    }

    public static boolean topologicalSort(Node node, Set<Integer> toVisit, Set<Integer> cycleSet, Stack<Integer> stack) {
        if (toVisit.contains(node.code)) {
            toVisit.remove(node.code);
            cycleSet.add(node.code);

            for (Node adj : node.directed) {
                if (cycleSet.contains(adj.code) || (toVisit.contains(adj.code) && topologicalSort(adj, toVisit, cycleSet, stack))) {
                    return true;
                }
            }
            
            stack.add(node.code);
        }

        cycleSet.remove(node.code);

        return false;
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
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
        
        Stack<Integer> orderStack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (!toVisit.contains(i)) {
                orderStack.add(i);
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (toVisit.contains(i)) {
                Set<Integer> cycleSet = new HashSet<>();
                if (topologicalSort(map.get(i), toVisit, cycleSet, orderStack)) {
                    return new int[]{};
                }
            }
        }

        int[] order = new int[orderStack.size()];
        for (int i = 0; !orderStack.isEmpty(); i++) {
            order[i] = orderStack.pop();
        }

        return order;
    }

    public static void main(String[] args) {
        findOrder(1, new int[][]{});
    }
}
