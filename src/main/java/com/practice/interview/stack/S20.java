package com.practice.interview.stack;

import java.util.List;
import java.util.Stack;

public class S20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                switch (stack.peek()) {
                    case '(' -> {
                        if (c.equals(')')) {
                            stack.pop();

                            continue;
                        }
                    }

                    case '{' -> {
                        if (c.equals('}')) {
                            stack.pop();

                            continue;
                        }
                    }

                    case '[' -> {
                        if (c.equals(']')) {
                            stack.pop();

                            continue;
                        }
                    }
                }
            }

            stack.add(c);
        }

        return stack.isEmpty();
    }
}
