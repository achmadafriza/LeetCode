package com.practice.interview.array;

public class S151 {
    public static void swap(String[] strings, int left, int right) {
        String temp = strings[left];
        strings[left] = strings[right];
        strings[right] = temp;
    }

    public static String[] reverse(String[] strings) {
        int left = 0;
        int right = strings.length - 1;
        while (left < right) {
            swap(strings, left, right);
            left++;
            right--;
        }

        return strings;
    }

    public static String reverseWords(String s) {
        return String.join(" ", reverse(s.trim().split("\\s+")));
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
    }
}
