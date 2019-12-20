package com.example.leetcode.No300_longest_increasing_subsequence;

import java.util.LinkedList;

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null) {
            return 0;
        }
        LinkedList<Integer> integers = new LinkedList<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            Integer peek = integers.peek();
            while (peek!= null && peek > nums[i]) {
                integers.poll();
                peek = integers.peek();
            }
            integers.push(nums[i]);
            if (integers.size() > max) {
                max = integers.size();
            }
        }
        return max;
    }
}