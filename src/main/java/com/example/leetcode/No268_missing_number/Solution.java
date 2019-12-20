package com.example.leetcode.No268_missing_number;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.missingNumber(new int[]{0,1,3,});
    }
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}