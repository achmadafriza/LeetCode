package com.practice.interview.stack;

public class S224 {
    static char[] chars;
    static int index;

    public static void skipWhitespace() {
        while (index < chars.length && chars[index] == ' ') {
            index++;
        }
    }

    public static int parseInt() {
        int result = 0;
        while(index < chars.length && Character.isDigit(chars[index])) {
            result = result * 10 + (chars[index] - '0');

            index++;
        }

        return result;
    }

    public static int parseUnaryNeg() {
        skipWhitespace();

        if (chars[index] == '(') {
            index++;
            return -parseParenthesis();
        }

        return -parseInt();
    }

    public static int parseParenthesis() {
        int result = 0;
        while (index < chars.length) {
            switch (chars[index]) {
                case '+', ' ' -> index++;

                case '(' -> {
                    index++;
                    result += parseParenthesis();
                }

                case '-' -> {
                    index++;
                    result += parseUnaryNeg();
                }

                case ')' -> {
                    index++;
                    return result;
                }

                default -> result += parseInt();
            }
        }

        throw new IllegalStateException();
    }

    public static int calculate(String s) {
        chars = s.toCharArray();
        index = 0;

        int result = 0;
        while (index < chars.length) {
            switch (chars[index]) {
                case '+', ' ' -> index++;

                case '(' -> {
                    index++;
                    result += parseParenthesis();
                }

                case '-' -> {
                    index++;
                    result += parseUnaryNeg();
                }

                default -> result += parseInt();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        calculate("1-(     -2)");
    }
}