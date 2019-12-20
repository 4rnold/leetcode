package com.example.leetcode.No334_increasing_triplet_subsequence;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.increasingTriplet(new int[]{1, 2, -10, -8, -7}));
    }
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int[] map = new int[nums.length];
        map[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    int tmp = map[j] + 1;
                    if (max < tmp) {
                        max = tmp;
                    }
                    if (tmp == 3) {
                        return true;
                    }
                }
            }
            map[i] = max;
        }
        return false;
    }
}                                 