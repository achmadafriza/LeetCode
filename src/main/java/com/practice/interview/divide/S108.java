package com.practice.interview.divide;

public class S108 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode recurseToBST(int[] nums, int left, int right) {
        if (right < left) {
            return null;
        }

        int pivotIndex = left + (right - left) / 2;
        int pivot = nums[pivotIndex];

        return new TreeNode(pivot, recurseToBST(nums, left, pivotIndex - 1), recurseToBST(nums, pivotIndex + 1, right));
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return recurseToBST(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }
}
