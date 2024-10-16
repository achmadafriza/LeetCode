package com.practice.interview.twopointers;

public class S125 {
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char leftChar = s.charAt(left);
            if ('A' <= leftChar && leftChar <= 'Z') {
                leftChar = (char) (leftChar - 'A' + 'a');
            }

            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
                continue;
            }

            char rightChar = s.charAt(right);
            if ('A' <= rightChar && rightChar <= 'Z') {
                rightChar = (char) (rightChar - 'A' + 'a');
            }

            if (!Character.isLetterOrDigit(rightChar)) {
                right--;
                continue;
            }

            if (leftChar != rightChar) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        isPalindrome("0P");
    }
}
