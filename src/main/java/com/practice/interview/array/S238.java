package com.practice.interview.array;

public class S238 {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroes = 0;
        for (int num : nums) {
            if (num != 0) {
                product *= num;
            } else {
                zeroes++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (zeroes > 0) {
                    nums[i] = 0;
                } else {
                    nums[i] = product / nums[i];
                }
            } else if (nums[i] == 0) {
                if (zeroes > 1) {
                    nums[i] = 0;
                } else {
                    nums[i] = product;
                }
            }
        }

        return nums;
    }
}
