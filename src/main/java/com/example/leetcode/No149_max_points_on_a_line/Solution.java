package com.example.leetcode.No149_max_points_on_a_line;

import java.util.ArrayList;

class Solution {
    public static void main(String[] args) {

//        int[][] a = {{1,1},{2,2},{3,3}};
//        int[][] a = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
//        int[][] a = {{1,1},{3,2}};
//        int[][] a = {{3,1},{12,3},{3,1},{-6,-1}};
        int[][] a = {{0,0},{94911151,94911150},{94911152,94911151}};
        Solution solution = new Solution();
        System.out.println(solution.maxPoints(a));

//        double b = 94911152;
//        double b2 = -b;
//        System.out.println(b2);
//
//        long b3 = 94911152;
//        long b4 = -b3;
//        System.out.println(b4);

    }

/*    public int maxPoints(int[][] points) {
        if (points.length == 1) {
            return 1;
        }
        ArrayList<double[]> function = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();


        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                //求直线方程
                if ((points[i][0] - points[j][0]) == 0) {
                    integers.add(points[i][0]);
                } else {
                    double k1 = (points[i][1] - points[j][1]);
                    double k2 = (points[i][0] - points[j][0]);
//                    double k = tmp1/ tmp2;
                    double k2b = k2*points[i][1] - k1 * points[i][0] ;
//                    double b = points[i][1] - k * points[i][0];
                    function.add(new double[]{k1, k2, k2b});
                }
            }
        }
        int max = 0;

        for (double[] ints : function) {
            int count = 0;
            for (int i = 0; i < points.length; i++) {
                //double result = points[i][0] * ints[0] + ints[1] - points[i][1];
                double result = points[i][0] * ints[0] + ints[2] - ints[1]*points[i][1];
                if (result == 0) {
                    count++;
                }
            }
            if (count > max) {
                max = count;
            }
        }

        for (Integer integer : integers) {
            int count = 0;
            for (int i = 0; i < points.length; i++) {
                if (points[i][0] == integer) {
                    count++;
                }
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }*/

    public int maxPoints(int[][] points) {
        if (points.length == 1) {
            return 1;
        }
        ArrayList<long[]> function = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();


        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                //求直线方程
                if ((points[i][0] - points[j][0]) == 0) {
                    integers.add(points[i][0]);
                } else {
                    long k1 = (points[i][1] - points[j][1]);
                    long k2 = (points[i][0] - points[j][0]);
//                    double k = tmp1/ tmp2;
                    long k2b = k2*points[i][1] - k1 * points[i][0] ;
//                    double b = points[i][1] - k * points[i][0];
                    function.add(new long[]{k1, k2, k2b});
                }
            }
        }
        int max = 0;

        for (long[] ints : function) {
            int count = 0;
            for (int i = 0; i < points.length; i++) {
                //double result = points[i][0] * ints[0] + ints[1] - points[i][1];
                long result = points[i][0] * ints[0] + ints[2] - ints[1]*points[i][1];
                if (result == 0) {
                    count++;
                }
            }
            if (count > max) {
                max = count;
            }
        }

        for (Integer integer : integers) {
            int count = 0;
            for (int i = 0; i < points.length; i++) {
                if (points[i][0] == integer) {
                    count++;
                }
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }
}