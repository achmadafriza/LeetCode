package com.tiktok;

public class S5 {
    public static int maxElement2(int n, int maxSum, int k) {
        int result = (int) Math.floor((double) maxSum / n);
        int remaining = maxSum % n;

        int gap = 0;
        while (remaining > 0) {
            remaining -= Math.min(n - 1, k + gap) - Math.max(0,  k - gap) + 1;
            if (remaining >= 0) {
                result++;
            }

            gap++;
        }

        return result;
    }

    public static int maxElement(int n, int maxSum, int k) {
        int left = k * ((k + 1) / 2);
        int right = (n - k - 1) * ((n - k) / 2);

        return (left + right + maxSum) / n;
    }

    public static void main(String[] args) {
        maxElement(3, 7, 1);
    }
}
