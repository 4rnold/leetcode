package com.example.leetcode.No190_reverse_bits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.reverseBits(245017234);

//        245 017 234‬
    }

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        String string = Integer.toBinaryString(n);
        char[] chars = string.toCharArray();
        ArrayList<String> characters = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            characters.add(String.valueOf(chars[i]));
        }
        Collections.reverse(characters);
        String join = String.join("", characters);
        int i = Integer.parseInt(join, 2);
        return i;
    }
}