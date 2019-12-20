package com.example.leetcode.No191_number_of_1_bits;

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int i1 = n & 1;
            if (i1 != 0) {
                count++;
            }
            n = n>>1;
        };

        return count;
    }
}