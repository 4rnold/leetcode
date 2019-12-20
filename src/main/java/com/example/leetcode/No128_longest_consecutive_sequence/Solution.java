package com.example.leetcode.No128_longest_consecutive_sequence;

import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        HashSet<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (numSet.remove(nums[i])) {
                //存在
                int count = 1;
                int plus = 1;
                while (numSet.remove(nums[i] + plus)) {
                    plus++;
                }
                count += plus-1;

                plus = -1;
                while (numSet.remove(nums[i] + plus)) {
                    plus--;
                }
                count -= plus+1;
                if (max < count) {
                    max = count;
                }
            }
        }
        return max;
    }
}