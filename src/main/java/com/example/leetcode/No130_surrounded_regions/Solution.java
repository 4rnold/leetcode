package com.example.leetcode.No130_surrounded_regions;

import java.util.Collections;

class Solution {

    public static void main(String[] args) {
//        char[][] a =
//                {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        char[][] a = {};
        Solution solution = new Solution();
        solution.solve(a);
        System.out.println();
    }


    public void solve(char[][] board) {
        if (board == null||board.length==0 ) {
            return;
        }
        char[][] clone = board.clone();
        for (int i = 0; i < clone.length; i++) {
            foo(clone, i, 0);
        }
        for (int i = 0; i < clone.length; i++) {
            foo(clone, i, clone[0].length - 1);
        }
        for (int j = 0; j < clone[0].length; j++) {
            foo(clone, 0, j);
        }
        for (int j = 0; j < clone[0].length; j++) {
            foo(clone, clone.length - 1, j);
        }

        foo(clone, 0, 0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (clone[i][j] == '2') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }

    }

    //将边界相连的填充2
    public void foo(char[][] board, int i, int j) {
        if (board.length <= i || i < 0 || j < 0 || board[0].length <= j) {
            return;
        }
        if (board[i][j] == 'O') {
            board[i][j] = '2';
            //探测周围节点
            foo(board, i + 1, j);
            foo(board, i - 1, j);
            foo(board, i, j + 1);
            foo(board, i, j - 1);
        }
    }
}