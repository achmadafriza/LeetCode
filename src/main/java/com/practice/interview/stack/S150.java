package com.practice.interview.stack;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Stack;

public class S150 {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+" -> stack.add(stack.pop() + stack.pop());

                case "-" -> {
                    int b = stack.pop();
                    int a = stack.pop();

                    stack.add(a - b);
                }

                case "*" -> stack.add(stack.pop() * stack.pop());

                case "/" -> {
                    int b = stack.pop();
                    int a = stack.pop();

                    stack.add(Math.divideExact(a, b));
                }

                default -> stack.add(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"});
    }
}
