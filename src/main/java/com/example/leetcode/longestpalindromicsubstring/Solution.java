package com.example.leetcode.longestpalindromicsubstring;

import org.springframework.util.CollectionUtils;

import javax.sound.sampled.ReverbType;

class Solution {
    static String resultStr = "";

    public static String longestPalindrome(String s) {
        resultStr = "";
        recusive(s);

        return resultStr;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babaddtattarrattatddetartrateedredividerb"));
    }

    public static void recusive(String string) {
        if (string.length() <= resultStr.length()) {
            return;
        }
        //判断是否回文
        String reverseStr = new StringBuilder(string).reverse().toString();
        if (reverseStr.equals(string)) {
            if (resultStr.length() < string.length()) {
                resultStr = string;
            }
            return;
        }

        //左减一，右减一
        String substring1 = string.substring(0, string.length() - 1);
        String substring2 = string.substring(1,string.length());

        recusive(substring1);
        recusive(substring2);
    }
}