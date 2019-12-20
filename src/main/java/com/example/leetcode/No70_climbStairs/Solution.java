package com.example.leetcode.No70_climbStairs;

class Solution {
    public static void main(String[] args) {
        System.out.println(climbStairs(1));
    }
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] m = new int[n];
        m[0] = 1;
        m[1] = 2;
        for (int i = 2; i < n; i++) {
            m[i] = m[i - 1] + 2 * m[i - 2];
        }
        return m[n-1];
    }
}