package com.practice.interview.graph;

import java.util.*;

public class S133 {
    private static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static Node cloneGraph2(Node node) {
        Queue<Node> workQueue = new LinkedList<>();
        Map<Node, Node> map = new HashMap<>();
        if (node != null) {
            workQueue.add(node);
            map.put(node, new Node(node.val, new ArrayList<>()));
        }

        Set<Node> visited = new HashSet<>();
        while (!workQueue.isEmpty()) {
            Node current = workQueue.poll();
            Node newNode = map.get(current);

            visited.add(current);
            for (Node adj : current.neighbors) {
                if (!visited.contains(adj)) {
                    workQueue.add(adj);
                }

                Node newAdj;
                if (!map.containsKey(adj)) {
                    newAdj = new Node(adj.val, new ArrayList<>());

                    map.put(adj, newAdj);
                } else {
                    newAdj = map.get(adj);
                }

                if (!newNode.neighbors.contains(newAdj)) {
                    newNode.neighbors.add(newAdj);
                }
            }
        }

        return map.get(node);
    }

    public static Node cloneNode(Node node, Map<Node, Node> map) {
        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(node, newNode);

        for (Node adj : node.neighbors) {
            newNode.neighbors.add(cloneNode(adj, map));
        }

        return newNode;
    }

    public static Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();

        if (node == null) {
            return null;
        }

        return cloneNode(node, map);
    }

    public static void main(String[] args) {
        List<Node> nodes = List.of(new Node(1, new ArrayList<>()), new Node(2, new ArrayList<>()), new Node(3, new ArrayList<>()), new Node(4, new ArrayList<>()));

        nodes.get(0).neighbors.addAll(List.of(
                nodes.get(1),
                nodes.get(3)
        ));

        nodes.get(1).neighbors.addAll(List.of(
                nodes.get(0),
                nodes.get(2)
        ));

        nodes.get(2).neighbors.addAll(List.of(
                nodes.get(1),
                nodes.get(3)
        ));

        nodes.get(3).neighbors.addAll(List.of(
                nodes.get(0),
                nodes.get(2)
        ));

        cloneGraph(nodes.get(0));
    }
}
