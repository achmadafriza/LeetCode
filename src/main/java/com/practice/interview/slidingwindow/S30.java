package com.practice.interview.slidingwindow;

import java.util.*;
import java.util.stream.Collectors;

public class S30 {
    public static boolean checkPermutation(String s, Map<String, Integer> wordSet, int i, int jump, int remainingWords) {
        if (remainingWords == 0) {
            return true;
        }

        if (i + jump > s.length()) {
            return false;
        }

        String substring = s.substring(i, i + jump);
        boolean result = false;
        if (wordSet.getOrDefault(substring, 0) > 0) {
            wordSet.put(substring, wordSet.get(substring) - 1);

            result = checkPermutation(s, wordSet, i + jump, jump, remainingWords - 1);

            wordSet.put(substring, wordSet.get(substring) + 1);
        }

        return result;
    }

    public static List<Integer> findSubstring2(String s, String[] words) {
        int maxSize = 0;
        Map<String, Integer> wordSet = new HashMap<>();
        for (String word : words) {
            wordSet.put(word, wordSet.getOrDefault(word, 0) + 1);
            maxSize += word.length();
        }

        int jump = words[0].length();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= s.length() - maxSize; i++) {
            if (checkPermutation(s, wordSet, i, jump, words.length)) {
                result.add(i);
            }
        }

        return result;
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> wordSet = new HashMap<>();
        for (String word : words) {
            wordSet.put(word, wordSet.getOrDefault(word, 0) + 1);
        }

        int jump = words[0].length();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < jump; i++) {
            int left = i;
            int right = i;

            int remaining = words.length;
            Map<String, Integer> remainingWords = new HashMap<>(wordSet);
            while (right + jump <= s.length()) {
                String rightSubstring = s.substring(right, right + jump);
                if (remainingWords.getOrDefault(rightSubstring, 0) > 0) {
                    remainingWords.put(rightSubstring, remainingWords.get(rightSubstring) - 1);

                    remaining--;
                    right += jump;
                } else if (left < right) {
                    String leftSubstring = s.substring(left, left + jump);

                    remainingWords.put(leftSubstring, remainingWords.get(leftSubstring) + 1);

                    left += jump;
                    remaining++;
                } else {
                    left += jump;
                    right += jump;
                }

                if (remaining == 0) {
                    result.add(left);

                    String leftSubstring = s.substring(left, left + jump);

                    remainingWords.put(leftSubstring, remainingWords.get(leftSubstring) + 1);

                    left += jump;
                    remaining++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo","barr","wing","ding","wing"});
    }
}
