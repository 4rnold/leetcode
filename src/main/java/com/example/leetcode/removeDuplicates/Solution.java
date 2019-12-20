package com.example.leetcode.removeDuplicates;

class Solution {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return nums.length;
        }
        int preNum = nums[0];
        int idx1 = 1;
//        int idx2 = 1;

        for (int i = 1; i < nums.length; i++) {
            if (preNum == nums[i]) {

            } else {
                nums[idx1] = nums[i];
                preNum = nums[i];
                idx1++;
            }
        }
        return idx1+1;
    }
}