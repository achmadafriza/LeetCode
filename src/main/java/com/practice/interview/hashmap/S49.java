package com.practice.interview.hashmap;

import java.util.*;
import java.util.stream.Collectors;

public class S49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String anagram = new String(chars);

            if (!anagrams.containsKey(anagram)) {
                anagrams.put(anagram, new ArrayList<>());
            }

            anagrams.get(anagram).add(s);
        }

        return new ArrayList<>(anagrams.values());
    }

    public static void main(String[] args) {
        groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }
}
