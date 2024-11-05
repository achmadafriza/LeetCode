package com.practice.interview.graph;

import java.util.*;

public class S127 {
    public static int diff(String s1, String s2) {
        int result = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                result++;
            }

            if (result > 1) {
                return result;
            }
        }

        return result;
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        Map<String, Integer> dist = new HashMap<>();
        for (String s : wordList) {
            dist.put(s, Integer.MAX_VALUE);
        }

        queue.add(beginWord);
        dist.put(beginWord, 0);
        dist.put(endWord, Integer.MAX_VALUE);
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            visited.add(curr);

            if (curr.equals(endWord)) {
                return dist.get(endWord) + 1;
            }

            char[] chars = curr.toCharArray();
            for (int i = 0; i < curr.length(); i++) {
                char original = chars[i];
                for (int c = 'a'; c <= 'z'; c++) {
                    chars[i] = (char) c;

                    String dst = new String(chars);
                    if (!visited.contains(dst) && wordSet.contains(dst) && dist.get(curr) + 1 < dist.get(dst)) {
                        dist.put(dst, dist.get(curr) + 1);

                        queue.add(dst);
                    }
                }

                chars[i] = original;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        ladderLength("hit", "cog", List.of(
                "hot","dot","dog","lot","log","cog"
        ));
    }
}
