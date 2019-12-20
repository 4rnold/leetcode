package com.example.leetcode.No200_number_of_islands;

class Solution {

    public static void main(String[] args) {
//        char[][] a = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        char[][] a = {{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','0','1','1'}};
        Solution solution = new Solution();
        System.out.println(solution.numIslands(a));
    }
    public int numIslands(char[][] grid) {
//        int[][] map = new int[grid.length][grid[0].length];

        char[][] map = grid.clone();

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (map[i][j] == '1') {
                    count++;
                    explore(map, i, j);
                }
            }
        }
        return count;
    }

    public static void explore(char[][] map, int i, int j) {
        if (i < 0 || i >= map.length || j < 0 || j >= map[0].length) {
            return;
        }
        if (map[i][j] == '2' || map[i][j] == '0') {
            return;
        } else {
            map[i][j] = '2';

            explore(map, i + 1, j);
            explore(map, i, j + 1);
            explore(map, i - 1, j);
            explore(map, i, j - 1);
        }
    }
}