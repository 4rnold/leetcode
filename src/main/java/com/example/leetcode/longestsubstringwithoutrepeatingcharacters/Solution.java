package com.example.leetcode.longestsubstringwithoutrepeatingcharacters;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public static void main(String[] args) {
        int bbbbb = lengthOfLongestSubstring("pwwkew");
        System.out.println(bbbbb);
    }
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();

        int start = 0;
        int end = 1;
        int max = 0;
        if (chars.length < 1) {
            return 0;
        }
        if (chars.length == 1) {
            return 1;
        }
        int length = 1;
        for (int i = 1; i < chars.length; i++) {
            //比较
            length = 1;
            for (int j = start; j < end; j++) {
                if (chars[j] == chars[end]) {
//                    int length = end - start;
//                    if (length > max) {
//                        max = length;
//                    }
                    length = 1;
                    start = j+1;
                    break;
                } else {
                    length ++;
                }
            }
            if (length > max) {
                max = length;
            }
            end++;

        }




        return max;
    }
}