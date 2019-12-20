package com.example.leetcode.No139_word_break;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordBreak("applepenapple", Arrays.asList("apple", "pn")));
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>();
        for (String s1 : wordDict) {
            wordSet.add(s1);
        }
//        ArrayList<String> strings = new ArrayList<>();
        HashSet<String> strings = new HashSet<>();
        strings.add("");
        for (int i = 0; i < s.length(); i++) {
            ArrayList<String> stage = new ArrayList<>();
            for (String string : strings) {
                String substring = s.substring(string.length(), i + 1);
                if (wordSet.contains(substring)) {
                    stage.add(string + substring);
                }
            }
            strings.addAll(stage);
        }
        for (String string : strings) {
            if (string.length() == s.length()) {
                return true;
            }
        }
        return false;
    }
}