package com.example.leetcode.No171_excel_sheet_column_number;

class Solution {
    public int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        Integer a = 0;
        for (char aChar : chars) {
            a = a* 26;
            a = aChar - 'A' + 1 + a;
        }
        return a;
    }
}