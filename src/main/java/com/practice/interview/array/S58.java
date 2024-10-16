package com.practice.interview.array;

public class S58 {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        return s.length() - s.lastIndexOf(' ') - 1;
    }
}
