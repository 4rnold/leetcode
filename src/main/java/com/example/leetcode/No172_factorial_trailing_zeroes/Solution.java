package com.example.leetcode.No172_factorial_trailing_zeroes;

class Solution {


    public int trailingZeroes(int n) {
        int result = 0;
        int i = n;
        while (i >= 5) {
            i = i / 5;
            result +=i;
        }
        return result;
    }
}