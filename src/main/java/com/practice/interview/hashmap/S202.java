package com.practice.interview.hashmap;

import java.util.HashSet;
import java.util.Set;

public class S202 {
    public static boolean isHappy2(int n) {
        Set<Integer> computed = new HashSet<>();
        do {
            computed.add(n);

            int calc = 0;
            while (n >= 10) {
                calc += (n % 10) * (n % 10);

                n /= 10;
            }

            calc += n * n;

            n = calc;
        } while (!computed.contains(n));

        return computed.contains(1);
    }

    /* Floyd's Tortoise and Hare algorithm: https://canbayar91.medium.com/algorithms-revisited-part-6-cycle-detection-17e6ad389bc7 */
    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = square(slow);
            fast = square(square(fast));
        } while (slow != fast);

        return slow == 1;
    }

    public static int square(int n) {
        int calc = 0;
        while (n >= 10) {
            calc += (n % 10) * (n % 10);

            n /= 10;
        }

        calc += n * n;

        return calc;
    }

    public static void main(String[] args) {
        isHappy(19);
    }
}
