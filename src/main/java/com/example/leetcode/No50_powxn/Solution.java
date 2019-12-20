package com.example.leetcode.No50_powxn;

class Solution {
    public static void main(String[] args) {
        System.out.println(Math.abs(-2147483648));
        System.out.println(myPow(2, -2147483648));

    }
    public static double myPow(double x, int n) {
        boolean neg = false;

        long nn = n;
        if (nn < 0) {
            nn = -nn;
            neg= true;
        }

        long tempN = nn;
        double tempX = x;
        double result = 1;

        while (tempN > 0) {
            long tag = tempN & 1;
            tempN = tempN >> 1;
            if (tag == 1) {
                result *= tempX;
            }
            tempX *= tempX;
        }

        if (neg == true) {
            return 1/result;
        }
        return result;
    }
}