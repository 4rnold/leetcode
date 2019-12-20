package com.example.leetcode.No62_uniquePaths;

class Solution {

    static Integer result = 0;


    public static void main(String[] args) {
        System.out.println(uniquePaths(1, 1));
    }
    public static int uniquePaths(int m, int n) {
//        Integer
        foo(m, n, 0,0);
        return result;

    }

    public static void foo(int m, int n, int i, int j) {
//        System.out.println(i + ":" + j);
        if (m == i + 1 && n == j + 1) {
            result++;
//            System.out.println();
            return;
        }
        int tempj = j +1;
        int tempi = i + 1;
        if (m == i + 1) {
            foo(m, n, i, tempj);
        } else if (n == j + 1) {
            foo(m, n, tempi, j);
        } else {

            foo(m, n, i, tempj);


            foo(m, n, tempi, j);
        }
    }
}