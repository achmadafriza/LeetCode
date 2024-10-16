package com.practice.interview.graph;

import java.util.*;

public class S399 {
    static class Node {
        String equation;
        Map<Node, Double> edges;

        Node(String equation) {
            this.equation = equation;
            this.edges = new HashMap<>();
        }
    }

    public static double calculate(Node node, Node target, Set<Node> visited) {
        if (visited.contains(node)) {
            return 0;
        }

        if (node.equation.equals(target.equation)) {
            return 1;
        }

        visited.add(node);

        double result;
        for (Map.Entry<Node, Double> edge : node.edges.entrySet()) {
            result = edge.getValue() * calculate(edge.getKey(), target, visited);

            if (result != 0) {
                return result;
            }
        }

        return 0;
    }

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Node> nodes = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);

            Node dividend = nodes.getOrDefault(equation.get(0), new Node(equation.get(0)));
            Node divisor = nodes.getOrDefault(equation.get(1), new Node(equation.get(1)));

            dividend.edges.put(divisor, values[i]);
            divisor.edges.put(dividend, 1 / values[i]);

            nodes.put(equation.get(0), dividend);
            nodes.put(equation.get(1), divisor);
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String target = queries.get(i).get(1);

            if (!nodes.containsKey(start) || !nodes.containsKey(target)) {
                result[i] = -1;
            } else if (start.equals(target)) {
                result[i] = 1;
            } else {
                result[i] = calculate(nodes.get(start), nodes.get(target), new HashSet<>());
                if (result[i] == 0) {
                    result[i] = -1;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        calcEquation(List.of(
                List.of("a", "b"),
                List.of("b", "c")
        ), new double[]{2, 3}, List.of(
                List.of("a", "c"),
                List.of("b", "a"),
                List.of("a", "e"),
                List.of("a", "a"),
                List.of("x", "x")
        ));
    }
}
