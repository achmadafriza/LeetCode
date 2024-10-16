package com.practice.interview.array;

import java.util.Arrays;

public class S135 {
    public static int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                candies[i] = Math.max(candies[i+1] + 1, candies[i]);
            }
        }

        return Arrays.stream(candies)
                .reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        candy(new int[]{1,3,4,5,2});
    }
}
