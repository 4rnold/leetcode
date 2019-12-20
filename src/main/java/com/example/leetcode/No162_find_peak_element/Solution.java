package com.example.leetcode.No162_find_peak_element;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findPeakElement(new int[]{1, 2, 3, 1}));
    }
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int b = 0;
            if (nums.length - 1 < i + 1) {
                b = Integer.MIN_VALUE;
            } else {
                b = nums[i + 1];
            }
            if (nums[i] > b) {
                return i;
            }
        }
        return 0;
    }
}