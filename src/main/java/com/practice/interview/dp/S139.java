package com.practice.interview.dp;

import java.util.ArrayList;
import java.util.List;

public class S139 {
    public static boolean tryWordBreak(Boolean[] dp, String s, List<String> wordDict) {
        if (s.isEmpty()) {
            return true;
        }

        if (dp[s.length()] != null) {
            return dp[s.length()];
        }

        boolean result = false;
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                result = result || tryWordBreak(dp, s.substring(word.length()), wordDict);
            }
        }

        dp[s.length()] = result;

        return result;
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        return tryWordBreak(new Boolean[s.length() + 1], s, wordDict);
    }

    public static void main(String[] args) {
        wordBreak("leetcode", List.of("leet", "code"));
    }
}
