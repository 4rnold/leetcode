package com.example.leetcode.isValidSudoku;

import java.util.*;

class Solution {

    public static Set<Character> box = new HashSet<>();

    public static void main(String[] args) {
        char[][] bo = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '9', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(isValidSudoku(bo));
    }


    public static boolean isValidSudoku(char[][] board) {
        ArrayList<Character> objects = new ArrayList<>();
        ArrayList<Character> objects2 = new ArrayList<>();
        //先验证行
        for (int i = 0; i < 9; i++) {
            objects.clear();
            objects2.clear();
            for (int j = 0; j < 9; j++) {
                objects.add(board[i][j]);
                objects2.add(board[j][i]);
            }
            if (valid(objects)==false || valid(objects2)==false) {
                return false;
            }
        }

        for (int i1 = 0; i1 < 3; i1++) {
            for (int j1 = 0; j1 < 3; j1++) {
                objects.clear();
                for (int i = 0 + 3*i1; i < 3 + 3*i1; i++) {
                    for (int j = 0 + 3*j1; j < 3+ 3*j1; j++) {
                        System.out.print(i + ":" + j + " ");
                        objects.add(board[j][i]);
                    }
                    System.out.println();
                }
                if (valid(objects)==false) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean valid(List<Character> list) {
        box.clear();
        for (Character character : list) {
            if (!character.equals('.')) {
                if (box.contains(character)) {
                    return false;
                } else {
                    box.add(character);
                }
            }
        }
        return true;
    }
}