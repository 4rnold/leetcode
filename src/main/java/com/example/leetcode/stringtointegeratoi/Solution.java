package com.example.leetcode.stringtointegeratoi;

class Solution {
    public static void main(String[] args) {
        System.out.println(myAtoi("+-2"));
    }


    public static int myAtoi(String str) {
        String string = str.trim();
        char[] chars = string.toCharArray();
        int result = 0;
        boolean positive = true;

        int idx = 0;
        for (char aChar : chars) {
            if (idx==0 && (aChar == '+' || aChar == '-')) {
                if (aChar == '-') {
                    positive = false;
                }
            }else if (aChar <= '9' && aChar >= '0') {
                int i = aChar - '0';
                if (positive == true) {
                    //正数
                    //防止溢出
                    if (Integer.MAX_VALUE/10 < result) {
                        return Integer.MAX_VALUE;
                    }
                    if (Integer.MAX_VALUE - result * 10 < i) {
                        return Integer.MAX_VALUE;
                    }
                    result = result * 10 + i;
                } else {
                    //负数
                    if (Integer.MIN_VALUE / 10 > result) {
                        return Integer.MIN_VALUE;
                    }
                    if (Integer.MIN_VALUE - result * 10 > -i) {
                        return Integer.MIN_VALUE;
                    }
                    result = result * 10 - i;
                }
            } else {
                break;
            }
            idx++;
        }
        return result;
    }
}