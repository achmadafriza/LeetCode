package com.tiktok;

import java.util.*;

public class S3 {
    public static final int prime = 131;
    public static final int modulo = 1_000_000_007;

    public static final List<Double> pow = new ArrayList<>();
    public static final List<Character> appended = new ArrayList<>();

    public static int hash(String password) {
        double hash = 0;
        for (int i = 0; i < password.length(); i++) {
            hash = hash + (password.charAt(password.length() - 1 - i) * pow.get(i));
        }

        return (int) (hash % modulo);
    }

    public static List<Integer> authEvents(List<List<String>> events) {
        for (int i = 0; i < 11; i++) {
            pow.add(Math.pow(prime, i));
        }

        String lastPassword = null;
        Integer hash = null;

        List<Integer> result = new ArrayList<>();
        for (List<String> event : events) {
            String command = event.get(0);
            switch (command) {
                case "setPassword":
                    lastPassword = event.get(1);
                    hash = hash(lastPassword);
                    break;
                case "authorize":
                    int checkHash = Integer.parseInt(event.get(1));

                    if (hash == null) {
                        result.add(0);
                    } else if (hash == checkHash) {
                        result.add(1);
                    } else {
                        int temp = hash(lastPassword + ((char) 1));
                        if (Character.isLetterOrDigit(checkHash - temp + 1)) {
                            result.add(1);
                        } else {
                            result.add(0);
                        }
                    }
                    break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        authEvents(Arrays.asList(
                Arrays.asList("setPassword", "000A"),
                Arrays.asList("authorize", "108738450"),
                Arrays.asList("authorize", "108738449"),
                Arrays.asList("authorize", "244736787")
        ));
    }
}
