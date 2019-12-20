package com.example.leetcode.longestCommonPrefix;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import java.lang.annotation.ElementType;

class Solution {

    public static void main(String[] args) {
        String[] a = new String[]{"a"};
        System.out.println(longestCommonPrefix(a));

    }
    public static String longestCommonPrefix(String[] strs) {

        int index = 0;
//        String prefix = "";
        int count = 0;
        if (strs.length == 0) {
            return "";
        }
        while (true) {
            count = 0;
            char tempC = ' ';
            for (String str : strs) {
                if (str.length()-1 < index ) {
                    break;
                }
                char c = str.charAt(index);
                if (count == 0) {
                    tempC = c;
                    count++;
                } else {
                    if (c == tempC) {
                        count++;
                    } else {
                        break;
                    }
                }
            }
            if (count == strs.length) {
                index++;
            } else {
                break;
            }
        }


        return strs[0].substring(0, index);
    }
}