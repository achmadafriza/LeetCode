package com.practice.interview.array;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class S68 {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> lines = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();

        int i = 0;
        int size = 0;
        while (i < words.length) {
            List<String> line = new ArrayList<>();
            while (size < maxWidth && i < words.length) {
                if (size + words[i].length() > maxWidth) {
                    break;
                }

                line.add(words[i]);
                line.add(" ");

                size += words[i].length() + 1;
                i++;
            }

            line.removeLast();
            size--;

            lines.add(line);
            sizes.add(size);

            size = 0;
        }

        for (i = 0; i < sizes.size() - 1; i++) {
            size = sizes.get(i);
            List<String> line = lines.get(i);

            int remainingSpace = maxWidth - size;
            if (line.size() == 1 && remainingSpace > 0) {
                line.add(" ");
                remainingSpace--;
            }

            while (remainingSpace > 0) {
                int j = 1;
                while (j < line.size() && remainingSpace > 0) {
                    line.add(j, line.remove(j) + " ");

                    remainingSpace--;
                    j += 2;
                }
            }
        }

        size = sizes.getLast();
        List<String> lastLine = lines.getLast();

        int remainingSpace = maxWidth - size;
        lastLine.addLast(lastLine.removeLast() + " ".repeat(remainingSpace));

        List<String> result = new ArrayList<>();
        for (List<String> line : lines) {
            result.add(String.join("", line));
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> strings = fullJustify(new String[]{"Listen","to","many,","speak","to","a","few."}, 6);

        for (String s : strings) {
            System.out.println(s);
        }
    }
}
