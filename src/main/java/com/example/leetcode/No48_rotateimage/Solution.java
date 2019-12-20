package com.example.leetcode.No48_rotateimage;

class Solution {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //横向旋转
        int a = 0;
        int b = matrix.length-1;
        while (a < b) {
            for (int i = 0; i < matrix.length; i++) {
                int temp = matrix[i][a];
                matrix[i][a] = matrix[i][b];
                matrix[i][b] = temp;
            }
            a++;
            b--;
        }
    }
}