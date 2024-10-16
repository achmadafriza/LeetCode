package com.practice.interview.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class S383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (Character c : magazine.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for (Character c : ransomNote.toCharArray()) {
            if (charCount.getOrDefault(c, 0) > 0) {
                charCount.put(c, charCount.get(c) - 1);
            } else {
                return false;
            }
        }

        return true;
    }
}
