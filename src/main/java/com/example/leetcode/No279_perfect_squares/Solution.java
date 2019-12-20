package com.example.leetcode.No279_perfect_squares;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSquares(1));
    }
    public int numSquares(int n) {
        int[] ints = new int[n];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            int num = i * i;
            if (num > n) {
                break;
            }
            for (int j = 0; j < n; j++) {
                if (j + 1 - num == 0) {
                    ints[j] = 1;
                } else if (j + 1 - num > 0) {
                    ints[j] = Math.min(ints[j - num] + 1, ints[j]);
                }
            }
        }
        return ints[n-1];
    }
}