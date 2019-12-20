package com.example.leetcode.longestpalindromicsubstring;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    //cbbaabb
    public static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        String resultStr = "";

        boolean[][] result = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) {
                    result[j][i] = true;
                }
                if (i == j + 1) {
                    if (chars[i] == chars[j]) {
                        result[j][i] = true;
                    } else {
                        result[j][i] = false;
                    }
                }
                if (i > j + 1) {
                    if (chars[i] == chars[j]) {
                        if (result[j + 1][i - 1] == true) {
                            result[j][i] = true;
                        }

                    } else {
                        result[j][i] = false;
                    }
                }
            }
        }
        boolean found = false;
        for (int t = 0; t < s.length(); t++) {
            for (int f = 0; f <= t; f++) {
                int i1 = t - f;//剩下给j的
                int i = s.length()-1 - f;
                int j = 0 + i1;
//                System.out.println(result[j][i]);
                if (result[j][i] == true) {
                    System.out.println(j);
                    System.out.println(i);
                    resultStr = s.substring(j, i+1);
                    found = true;
                    break;
                }
            }
            if (found == true) {
                break;
            }
        }


        return resultStr;
    }
}
