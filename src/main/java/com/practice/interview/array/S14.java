package com.practice.interview.array;

import java.util.Arrays;

public class S14 {
    public String longestCommonPrefix2(String[] strs) {
        String prefix = "";

        int i = 0;
        while (i < strs[0].length()) {
            prefix += strs[0].charAt(i);
            for (String s : strs) {
                if (!s.startsWith(prefix)) {
                    return prefix.substring(0, prefix.length()-1);
                }
            }

            i++;
        }

        return prefix;
    }

    public String longestCommonPrefix(String[] v) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(v);
        String first = v[0];
        String last = v[v.length-1];
        for (int i=0; i<Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }
}
