package com.example.leetcode.No91_decode_ways;

class Solution {

    public static void main(String[] args) {
//        char[] a = {'2', '2'};
//        //String i = a[0] + a[1] + "";
//        Integer i = Integer.valueOf(String.valueOf(a[0]));
//        System.out.println(i);
//        System.out.println('B' - 'A');
        System.out.println(numDecodings("101"));

    }
    public static int numDecodings(String s) {
        char[] chars = s.toCharArray();

        boolean one = false;
        boolean two = false;

        int[] count = new int[chars.length];
        if (chars.length < 1) {
            return 0;
        }

        if (charToInt(chars[0]) <= 26 && charToInt(chars[0]) > 0) {
            count[0] = 1;
        } else {
            return 0;
        }

        if (chars.length > 1) {
            int i = 0;
            int i1 = charToInt(chars[0]) * 10 + charToInt(chars[1]);
            if (i1 <= 26 && i1 >0) {
                i++;
                //count[1] = 2;
                two = true;
            }
            if (charToInt(chars[1]) != 0) {
                i++;
                one = true;
            }
            if (one == false && two == false) {
                return 0;
            }
            count[1] = i;
        }

        for (int i = 2; i < chars.length; i++) {
            one = false;
            two = false;
            int c = 0;
            int i2 = charToInt(chars[i - 1]) * 10 + charToInt(chars[i]);
//            count[i] = count[i - 1];
            if (i2 <=26 && i2 >0 && chars[i-1] != '0') {
//                count[i] += count[i - 2];
                c += count[i - 2];
                two = true;
            }
            if (charToInt(chars[i]) != 0) {
                one = true;
                c += count[i - 1];
            }
            if (one == false && two == false) {
                return 0;
            }
            count[i] = c;

        }

        return count[count.length-1];
    }

    public static int charToInt(char c) {
        return Integer.valueOf(String.valueOf(c));
    }
}