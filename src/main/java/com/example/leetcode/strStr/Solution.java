package com.example.leetcode.strStr;

class Solution {

    public static void main(String[] args) {
        System.out.println(strStr("aaa", "a"));
    }
    public static int strStr(String haystack, String needle) {
        char[] haystackArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();
        if (needleArray.length == 0) {
            return 0;
        }

        int start = -1;

        for (int startIdx = 0; startIdx < haystackArray.length; startIdx++) {
            int idx = startIdx;
            for (int j = 0; j < needleArray.length; j++) {
                if (idx < haystackArray.length && haystackArray[idx] == needleArray[j]) {
                    if (j == needleArray.length - 1) {
                        start = startIdx;
                        break;
                    }
                } else {
                    break;
                }
                idx++;
            }
            if (start != -1) {
                break;
            }
        }

        return start;

    }
}