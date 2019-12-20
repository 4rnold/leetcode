package com.example.leetcode.letterCombinations;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
    }

    public static List<String> letterCombinations(String digits) {
        Map<String, String> telMap = new HashMap<>();
        telMap.put("2", "abc");
        telMap.put("3", "def");
        telMap.put("4", "ghi");
        telMap.put("5", "jkl");
        telMap.put("6", "mno");
        telMap.put("7", "pqrs");
        telMap.put("8", "tuv");
        telMap.put("9", "wxyz");

        HashMap<String, char[]> map = new HashMap<>();
        for (Map.Entry<String, String> stringStringEntry : telMap.entrySet()) {
            char[] chars = stringStringEntry.getValue().toCharArray();
            map.put(stringStringEntry.getKey(), chars);
        }

        char[] chars = digits.toCharArray();
        List<String> result = new ArrayList<>();
        for (char aChar : chars) {
            char[] chars1 = map.get(String.valueOf(aChar));
            if (result.isEmpty()) {
                for (char c : chars1) {
                    result.add(String.valueOf(c));
                }
            } else {
                ArrayList<String> objects = new ArrayList<>();
                for (char c : chars1) {

                    for (String s : result) {
                        String s1 = s + String.valueOf(c);

                        objects.add(s1);
                    }
                }
                result = objects;
            }
        }

        return result;


    }
}