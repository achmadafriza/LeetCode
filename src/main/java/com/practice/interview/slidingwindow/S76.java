package com.practice.interview.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class S76 {
    public static String minWindow(String s, String t) {
        Map<Character, Integer> substring = new HashMap<>();
        for (char c : t.toCharArray()) {
            substring.put(c, substring.getOrDefault(c, 0) + 1);
        }

        String min = "";
        int minLength = Integer.MAX_VALUE;

        int left = 0;
        int right = -1;
        Map<Character, Integer> checkMap = new HashMap<>();
        while (right < s.length() - 1) {
            boolean check = true;
            for (Map.Entry<Character, Integer> entry : substring.entrySet()) {
                check = check && checkMap.getOrDefault(entry.getKey(), 0) >= entry.getValue();
            }

            if (!check) {
                right++;

                if (substring.containsKey(s.charAt(right))) {
                    checkMap.put(s.charAt(right), checkMap.getOrDefault(s.charAt(right), 0) + 1);
                }
            } else {
                if (right - left + 1 < minLength) {
                    min = s.substring(left, right + 1);
                    minLength = min.length();
                }

                int count = checkMap.getOrDefault(s.charAt(left), 0);
                if (substring.containsKey(s.charAt(left)) && count > 0) {
                    checkMap.put(s.charAt(left), count - 1);
                }

                left++;
            }
        }

        while (true) {
            boolean check = true;
            for (Map.Entry<Character, Integer> entry : substring.entrySet()) {
                check = check && checkMap.getOrDefault(entry.getKey(), 0) >= entry.getValue();
            }

            if (!check) {
                break;
            }

            if (right - left + 1 < minLength) {
                min = s.substring(left, right + 1);
                minLength = min.length();
            }

            int count = checkMap.getOrDefault(s.charAt(left), 0);
            if (substring.containsKey(s.charAt(left)) && count > 0) {
                checkMap.put(s.charAt(left), count - 1);
            }

            left++;
        }

        return min;
    }

    public static void main(String[] args) {
        minWindow("a", "a");
    }
}
