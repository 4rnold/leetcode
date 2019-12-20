//package com.example.leetcode.No76_minimum_window_substring;
//
//import cn.hutool.json.JSONUtil;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//class Solution {
//
//    public static void main(String[] args) {
//        Set[][] tableSet = new HashSet[2][2];
//
//        for (int i = 0; i < tableSet.length; i++) {
//            for (int j = 0; j < tableSet.length; j++) {
//                tableSet[i][j] = new HashSet<String>();
//            }
//        }
//
//        tableSet[1][1].add("A");
//        System.out.println(JSONUtil.toJsonStr(tableSet));
//    }
//
//
//
//    public String minWindow(String s, String t) {
//
////        List<List<Set<Character>>> table = new ArrayList<>();
//
//
//        Set<Character> charSet = new HashSet<>();
//        char[] chars1 = t.toCharArray();
//        for (char c : chars1) {
//            charSet.add(c);
//        }
//
//        char[] chars = s.toCharArray();
//        Set[][] tableSet = new HashSet[chars.length][chars.length];
//
//        for (int i = 0; i < tableSet.length; i++) {
//            for (int j = 0; j < tableSet.length; j++) {
//                tableSet[i][j] = new HashSet<String>();
//            }
//        }
//
//
//        for (int i = 0; i < chars.length; i++) {
//            char lackChar = ' ';
//            if (i != 0) {
//                lackChar = chars[i - 1];
//            }
//
//            for (int j = i; j < chars.length; j++) {
//
//                if (i == 0) {
//
//
//                    if (charSet.contains(chars[j])) {
//                        //包含字幕则添加
//                        tableSet[j][i].add(chars[j]);
//                    } else {
//                        //不包含新字符，和前面的一样，直接clone
//                        if (j == 0) {
//
//                        } else {
//                            tableSet[j][i].addAll(tableSet[j - 1][i]);
//                        }
//                    }
//                } else {
//
//
//                    //这一行缺失的首字符
//                    HashSet<String> tempPreSet = new HashSet<>();
//                    tempPreSet.addAll(tableSet[j][i - 1]);
//                    tempPreSet.remove(lackChar);
//
////                    Set pre = tableSet[j][i - 1];
//
//
//
//                    tableSet[j][i].addAll(set);
//                    if (set.contains(lackChar)) {
//                        tableSet[j][i].remove(lackChar);
//                    }
//
//
//                    //tableSet[j][i] =
//
//                }
//            }
//        }
//        return null;
//    }
//}