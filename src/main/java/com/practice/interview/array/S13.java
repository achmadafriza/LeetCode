package com.practice.interview.array;

public class S13 {
    public int romanToInt(String s) {
        s += "0";

        int ans = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            char next = s.charAt(i+1);
            switch (c) {
                case 'I' -> {
                    if (next == 'V' || next == 'X') {
                        ans -= 1;
                    } else {
                        ans += 1;
                    }
                }
                case 'V' -> ans += 5;
                case 'X' -> {
                    if (next == 'L' || next == 'C') {
                        ans -= 10;
                    } else {
                        ans += 10;
                    }
                }
                case 'L' -> ans += 50;
                case 'C' -> {
                    if (next == 'D' || next == 'M') {
                        ans -= 100;
                    } else {
                        ans += 100;
                    }
                }
                case 'D' -> ans += 500;
                case 'M' -> ans += 1000;
            }
        }

        return ans;
    }
}
