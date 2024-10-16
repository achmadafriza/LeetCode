package com.practice.interview.hashmap;

import java.util.HashMap;
import java.util.Map;

public class S205 {
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> charMap1 = new HashMap<>();
        Map<Character, Character> charMap2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (charMap1.containsKey(s.charAt(i)) && charMap1.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }

            if (charMap2.containsKey(t.charAt(i)) && charMap2.get(t.charAt(i)) != s.charAt(i)) {
                return false;
            }

            charMap1.put(s.charAt(i), t.charAt(i));
            charMap2.put(t.charAt(i), s.charAt(i));
        }

        return true;
    }

    public static void main(String[] args) {
        isIsomorphic("badc", "baba");
    }
}
