package com.example.leetcode.No73_setZeroes;

import cn.hutool.json.JSONUtil;

import java.util.HashSet;

class Solution {

    public static void main(String[] args) {
//        int[][] a = {
//  {1,1,1},
//  {1,0,1},
//  {1,1,1}
//};
        int[][] a = {};
        setZeroes(a);
        System.out.println(JSONUtil.toJsonStr(a));
    }
    public static void setZeroes(int[][] matrix) {
        HashSet<Integer> column = new HashSet<>();
        HashSet<Integer> row = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    column.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (column.contains(j) || row.contains(i)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}