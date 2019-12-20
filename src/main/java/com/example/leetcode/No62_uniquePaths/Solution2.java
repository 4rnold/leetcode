package com.example.leetcode.No62_uniquePaths;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(uniquePaths(1, 3));
    }

    public static int uniquePaths(int m, int n) {
        int[] result = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (j == 0 && i == 0) {
                    result[j] = 1;
                } else if (i == 0) {
                    result[j] = result[j -1];
                } else if (j == 0) {
//                    result[j] = result[j]
                } else {
                    result[j] = result[j - 1] + result[j];
                }
            }
        }

        return result[m - 1];
    }
}
