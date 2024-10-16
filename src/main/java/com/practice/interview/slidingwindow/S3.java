package com.practice.interview.slidingwindow;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class S3 {
    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 1;

        int max = 0;
        Set<Character> charset = new HashSet<>();
        if (!s.isEmpty()) {
            charset.add(s.charAt(0));
            max = 1;
        }

        while (right < s.length()) {
            while (charset.contains(s.charAt(right))) {
                charset.remove(s.charAt(left));
                left++;
            }

            charset.add(s.charAt(right));
            right++;

            max = Math.max(max, charset.size());
        }

        return max;
    }

    public static void main(String[] args) {

    }
}
