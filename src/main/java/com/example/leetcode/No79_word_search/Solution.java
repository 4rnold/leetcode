package com.example.leetcode.No79_word_search;

import cn.hutool.json.JSONUtil;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
//        int[] a = new int[]{1, 2};
//        test(a);
//        System.out.println(JSONUtil.toJsonStr(a));
//
//        int[] b = new int[]{1, 2, 3};
//        int[] clone = b.clone();
//        b[1] = 88;
//        System.out.println(JSONUtil.toJsonStr(clone));
//
//        int[][] c = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] clone1 = c.clone();
//        c[1][1]=888;
//        System.out.println(JSONUtil.toJsonStr(clone1));
//        int[][] newa = new int[2][2];
//        int
//
//        Arrays.fill(newa, 1);
//        System.out.println(JSONUtil.toJsonStr(newa));
char[][] a = {
  {'A','B','C','E'},
  {'S','F','C','S'},
  {'A','D','E','E'}
};
//char[][] a = {{'A','B'}};
        System.out.println(exist(a, "ABCESEEDASFC"));

    }

    static boolean result = false;

    public static boolean exist(char[][] board, String word) {
        result = false;
        char[] chars = word.toCharArray();



        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int[][] map = new int[board.length][board[0].length];
                for (int m = 0; m < map.length; m++) {
                    Arrays.fill(map[m], 0);
                }
                foo(j, i, 0, chars, board, map);
                if (result == true) {
                    return result;
                }
            }
        }
        return result;
    }


    public static void foo(int curX, int curY, int idx, char[] word, char[][] board, int[][] map) {
        if (result == true) {
            return;
        }
        if (!(curX < board[0].length) || !(curY < board.length) || curX < 0 || curY<0) {
            return;
        }

        if (map[curY][curX] == 1) {
            return;
        }
        if (board[curY][curX] != word[idx]) {
            return;
        }

        map[curY][curX] = 1;
        if (idx == word.length - 1) {
            result = true;
            return;
        }
        int[][] map1 = copyArray(map);
        //copy map
        foo(curX + 1, curY, idx + 1, word, board, map1);

        int[][] map2 = copyArray(map);
        //copy map
        foo(curX - 1, curY, idx + 1, word, board, map2);

        int[][] map3 = copyArray(map);
        //copy map
        foo(curX, curY + 1, idx + 1, word, board, map3);

        int[][] map4 = copyArray(map);
        //copy map
        foo(curX, curY - 1, idx + 1, word, board, map4);

    }

    public static int[][] copyArray(int[][] array) {
        int[][] newArr = new int[array.length][array[0].length];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = array[i].clone();
        }
        return newArr;
    }

}