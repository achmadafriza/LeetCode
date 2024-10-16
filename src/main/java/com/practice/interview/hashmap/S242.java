package com.practice.interview.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class S242 {
    public boolean isAnagram2(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();

        for (char x : s.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        for (char x : t.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) - 1);
        }

        for (int val : count.values()) {
            if (val != 0) {
                return false;
            }
        }

        return true;
    }

    public boolean isAnagram(String s, String t) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        s = new String(chars);

        chars = t.toCharArray();
        Arrays.sort(chars);
        t = new String(chars);

        return s.equals(t);
    }
}
