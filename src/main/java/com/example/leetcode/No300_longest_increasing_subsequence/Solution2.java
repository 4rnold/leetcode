package com.example.leetcode.No300_longest_increasing_subsequence;

import java.util.LinkedList;

class Solution2 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int[] map = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
//            map[i] = //前面比他小的 + 1

            int a = i-1;
            int tmpMax = 0;
            while (a >= 0) {
                if (nums[a] < nums[i]) {
                    if (tmpMax < map[a]) {
                        tmpMax = map[a];
                    }
                }
                a--;
            }
            if (tmpMax == 0) {
                map[i] = 1;
            } else {
                map[i] = tmpMax + 1;
            }
        }

        int result = 0;
        for (int i : map) {
            if (i > result) {
                result = i;
            }
        }
        return result;
    }
}