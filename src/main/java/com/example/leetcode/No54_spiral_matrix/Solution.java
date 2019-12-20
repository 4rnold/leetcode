package com.example.leetcode.No54_spiral_matrix;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
//        int[][] a = {
// { 1, 2, 3 },
// { 4, 5, 6 },
// { 7, 8, 9 }
//};
        int[][] a = {{1}};
        System.out.println(spiralOrder(a));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        int type = 1;

        int i = 0;
        int j = 0;
        if (matrix.length == 0) {
            return new ArrayList<>();
        }

        int barrierLeft = 0;
        int barrierRight = matrix[0].length -1;
        int barrierTop = 0;
        int barrierBottom = matrix.length -1;

        ArrayList<Integer> result = new ArrayList<>();
//        result.add(matrix[0][0]);

        while (true) {
//            if (barrierLeft > barrierRight || barrierTop > barrierBottom) {
//                break;
//            }

            if (type == 1) {
                if (i == barrierRight) {
                    //到边界,最后一个
                    type = type%4 + 1;
                    result.add(matrix[j][i]);
                    barrierTop++;
                    j++;
                    if (barrierTop > barrierBottom) {
                        break;
                    }
//                    i++;
                } else {
                    result.add(matrix[j][i]);
                    i++;
                }
            }

            else if (type == 2) {
                if (j == barrierBottom) {
                    //到边界
                    type = type%4 + 1;
                    result.add(matrix[j][i]);
                    i--;
                    barrierRight--;
                    if (barrierRight < barrierLeft) {
                        break;
                    }
//                    j++;
                } else {
                    result.add(matrix[j][i]);

                    j++;
                }
            }
            else if (type == 3) {
                if (i == barrierLeft) {
                    //到边界
                    type = type%4 + 1;
                    result.add(matrix[j][i]);
                    barrierBottom--;
                    j--;
                    if (barrierBottom < barrierTop) {
                        break;
                    }
//                    i--;
                } else {
                    result.add(matrix[j][i]);

                    i--;
                }
            }
            else if (type == 4) {
                if (j == barrierTop) {
                    //到边界
                    type = type%4 + 1;
                    result.add(matrix[j][i]);
                    barrierLeft++;
                    i++;
                    if (barrierLeft > barrierRight) {
                        break;
                    }
//                    j--;
                } else {
                    result.add(matrix[j][i]);

                    j--;
                }
            }

        }

        return result;
    }
}