package com.practice.interview.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class S71 {
    public String simplifyPath(String path) {
        Stack<String> canonical = new Stack<>();
        for (String dir : path.split("/")) {
            switch (dir) {
                case ".." -> {
                    if (!canonical.isEmpty()) {
                        canonical.pop();
                    }
                }

                case "", "." -> { }

                default -> canonical.add(dir);
            }
        }

        return "/" + String.join("/", canonical);
    }
}
