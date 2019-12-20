package com.example.leetcode.No344_reverse_string;

class Solution {
    public void reverseString(char[] s) {
        if (s == null) {
            return;
        }
        int a = 0;
        int b = s.length -1;

        while (a < b) {
            //交换
            char tmp = s[a];
            s[a] = s[b];
            s[b] = tmp;
            a++;
            b--;
        }
    }
}