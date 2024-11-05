package com.practice.interview.backtrack;

import java.util.ArrayList;
import java.util.List;

public class S22 {
    public static void tryOpen(List<String> result, StringBuilder builder, int leftRemaining, int rightRemaining) {
        if (leftRemaining <= 0) {
            tryClose(result, builder, leftRemaining, rightRemaining);

            return;
        }

        builder.append('(');

        tryClose(result, builder, leftRemaining - 1, rightRemaining);

        builder.deleteCharAt(builder.length() - 1);
    }

    public static void tryClose(List<String> result, StringBuilder builder, int leftRemaining, int rightRemaining) {
        if (leftRemaining == 0 && rightRemaining == 0) {
            result.add(builder.toString());

            return;
        }

        if (rightRemaining <= 0) {
            return;
        }

        if (leftRemaining < rightRemaining) {
            builder.append(')');

            tryClose(result, builder, leftRemaining, rightRemaining - 1);

            builder.deleteCharAt(builder.length() - 1);
        }

        if (leftRemaining > 0) {
            tryOpen(result, builder, leftRemaining, rightRemaining);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        tryOpen(result, new StringBuilder(), n, n);

        return result;
    }


    public static void main(String[] args) {
        generateParenthesis(3);
    }
}
