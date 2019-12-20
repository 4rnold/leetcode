package com.example.leetcode.No53_maximum_subarray;

class Solution {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2}));
    }
    public static int maxSubArray(int[] nums) {
        int[] max = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                max[i] = nums[i];
            } else {
                int max1 = max[i - 1];
                if (max1 < 0) {
                    max[i] = nums[i];
                } else {
                    max[i] = nums[i] + max1;
                }
            }
        }
        int result = Integer.MIN_VALUE;
        for (int i : max) {
            if (i > result) {
                result = i;
            }
        }
        return result;
    }
}