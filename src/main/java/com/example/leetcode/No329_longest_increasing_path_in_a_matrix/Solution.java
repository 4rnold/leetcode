package com.example.leetcode.No329_longest_increasing_path_in_a_matrix;

class Solution {

    public static void main(String[] args) {
        int[][] a = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };

//        [[0,1,2,3,4,5,6,7,8,9],[19,18,17,16,15,14,13,12,11,10],[20,21,22,23,24,25,26,27,28,29],[39,38,37,36,35,34,33,32,31,30],[40,41,42,43,44,45,46,47,48,49],[59,58,57,56,55,54,53,52,51,50],[60,61,62,63,64,65,66,67,68,69],[79,78,77,76,75,74,73,72,71,70],[80,81,82,83,84,85,86,87,88,89],[99,98,97,96,95,94,93,92,91,90],[100,101,102,103,104,105,106,107,108,109],[119,118,117,116,115,114,113,112,111,110],[120,121,122,123,124,125,126,127,128,129],[139,138,137,136,135,134,133,132,131,130],[0,0,0,0,0,0,0,0,0,0]]
        Solution solution = new Solution();
        System.out.println(solution.longestIncreasingPath(a));
    }

    public static int max = Integer.MIN_VALUE;
    public static int[][] cacheCount = null;


    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length ==0 || matrix[0].length == 0) {
            return 0;
        }
        cacheCount = new int[matrix.length][matrix[0].length];
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Integer.MIN_VALUE;
                foo(matrix, i, j, 0, Integer.MIN_VALUE);
                if (result < max) {
                    result = max;
                }
            }
        }
        return result < 0?0:result;
    }

    public void foo(int[][] matrix, int i, int j, int count, int preNum) {
        if (i < 0 || i > matrix.length - 1 || j < 0 || j > matrix[0].length-1) {
            return;
        }

        if (preNum < matrix[i][j]) {
            count++;

            //查缓存，如果count小于当前则直接返回
            int i1 = cacheCount[i][j];
            if (i1 > count) {
                return;
            } else {
                cacheCount[i][j] = count;
            }

            if (max < count) {
                max = count;
            }
            foo(matrix, i + 1, j, count, matrix[i][j]);
            foo(matrix, i, j + 1, count, matrix[i][j]);
            foo(matrix, i - 1, j, count, matrix[i][j]);
            foo(matrix, i, j - 1, count, matrix[i][j]);
        }

    }
}