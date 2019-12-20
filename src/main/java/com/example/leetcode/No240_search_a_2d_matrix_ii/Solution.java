package com.example.leetcode.No240_search_a_2d_matrix_ii;

class Solution {
    public static void main(String[] args) {

    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int i = 0;
        int j = matrix[0].length -1;

        while (i < matrix.length && j >= 0) {
            int i1 = matrix[i][j];
            if (i1 == target) {
                return true;
            }
            if (i1 > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}