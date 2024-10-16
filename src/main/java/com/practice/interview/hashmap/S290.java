package com.practice.interview.hashmap;

import java.util.HashMap;
import java.util.Map;

public class S290 {
    public static boolean wordPattern(String pattern, String s) {
         String[] words = s.split("\\s+");
         if (pattern.length() != words.length) {
             return false;
         }

         Map<Character, String> charMap = new HashMap<>();
         Map<String, Character> wordMap = new HashMap<>();
         for (int i = 0; i < pattern.length(); i++) {
             if (charMap.containsKey(pattern.charAt(i)) && !charMap.get(pattern.charAt(i)).equals(words[i])) {
                 return false;
             }

             if (wordMap.containsKey(words[i]) && !wordMap.get(words[i]).equals(pattern.charAt(i))) {
                 return false;
             }

             charMap.put(pattern.charAt(i), words[i]);
             wordMap.put(words[i], pattern.charAt(i));
         }

         return true;
    }

    public static void main(String[] args) {
        wordPattern("abba", "dog cat cat dog");
    }
}
