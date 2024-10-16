package com.practice.interview.twopointers;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class S15 {
    public static int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;

            if (target < nums[mid]) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> ans = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int result = binarySearch(nums, j + 1, nums.length - 1, - nums[i] - nums[j]);
                if (result != -1) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[result]));
                }
            }
        }

        return ans.stream().toList();
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Set<List<Integer>> ans = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            map.put(nums[i], map.get(nums[i]) - 1);

            for (int j = i + 1; j < nums.length - 1; j++) {
                map.put(nums[j], map.get(nums[j]) - 1);

                int target = - nums[i] - nums[j];
                if (map.containsKey(target) && map.get(target) > 0) {
                    List<Integer> pair = Arrays.asList(nums[i], nums[j], target);
                    Collections.sort(pair);

                    ans.add(pair);
                }

                map.put(nums[j], map.get(nums[j]) + 1);
            }

            map.put(nums[i], map.get(nums[i])+- 1);
        }

        return ans.stream().toList();
    }

    public static List<List<Integer>> threeSum3(int[] nums) {
        Arrays.sort(nums);

        int i = 0;
        int j = nums.length - 1;
        List<List<Integer>> ans = new ArrayList<>();
        while (i < j && j - i >= 3) {
            if (Math.abs(nums[i]) <= Math.abs(nums[j])) {
                for (int k = i + 1; k < j; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }

                    if (nums[k] == 0) {
                        break;
                    }
                }
            } else {
                for (int k = j - 1; k > i; k--) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }

                    if (nums[k] == 0) {
                        break;
                    }
                }
            }

            i++;
            j--;
        }

        return ans;
    }

    public static void main(String[] args) {
        threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}
