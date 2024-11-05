package com.practice.interview.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class S17 {
    public static void recurse(String digits, String result, List<String> list) {
        if ("".equals(digits)) {
            if (!"".equals(result)) {
                list.add(result);
            }

            return;
        }

        char digit = digits.charAt(0);
        String next = digits.substring(1);
        switch (digit) {
            case '7' -> {
                for (int i = 0; i < 4; i++) {
                    char add = (char) ('p' + i);
                    recurse(next, result + add, list);
                }
            }

            case '8' -> {
                for (int i = 0; i < 3; i++) {
                    char add = (char) ('t' + i);
                    recurse(next, result + add, list);
                }
            }

            case '9' -> {
                for (int i = 0; i < 4; i++) {
                    char add = (char) ('w' + i);
                    recurse(next, result + add, list);
                }
            }

            default -> {
                for (int i = 0; i < 3; i++) {
                    char add = (char) (((digit - '2') * 3) + 'a' + i);
                    recurse(next, result + add, list);
                }
            }
        }
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        recurse(digits, "", result);

        return result;
    }

    public static void main(String[] args) {
        letterCombinations("23");
    }
}
