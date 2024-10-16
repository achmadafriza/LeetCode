package com.practice.interview.array;

public class S6 {
    public static String convert(String s, int numRows) {
        StringBuilder builder = new StringBuilder();
        int initialGap = numRows * 2 - 2;
        if (numRows == 1) {
            initialGap = 1;
        }

        int i = 0;
        int currentGap = initialGap;
        while (builder.length() < s.length()) {
            int j = i;
            while (j < s.length()) {
                builder.append(s.charAt(j));

                j += currentGap;
                if (currentGap != initialGap) {
                    currentGap = initialGap - currentGap;
                }
            }

            i++;

            currentGap = initialGap - 2 * i;
            if (currentGap == 0) {
                currentGap = initialGap;
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        convert("A", 1);
    }
}
