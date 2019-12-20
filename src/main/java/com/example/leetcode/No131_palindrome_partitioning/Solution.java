package com.example.leetcode.No131_palindrome_partitioning;

import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<List<String>> result = new ArrayList<>();

    public static void main(String[] args) {
//        System.out.println("abc".substring(0,1));
        System.out.println(JSONUtil.toJsonStr(partition("")));
    }
    public static List<List<String>> partition(String s) {
        result.clear();
        foo(s, new ArrayList<>());
        return result;
    }

    public static void foo(String str,List<String> stageList) {
        if (str == null || str.length() == 0) {
            return;
        }
        //前n是否回文
        for (int i = 1; i <= str.length(); i++) {
            ArrayList<String> strings = new ArrayList<>(stageList);
            String substring = str.substring(0, i);
            if (ishuiwen(substring)) {
                strings.add(substring);
                if (i == str.length()) {
                    result.add(strings);
                }
                //后半段递归
                String substring2 = str.substring(i, str.length());
                foo(substring2,strings);
            }
        }
    }

    public static boolean ishuiwen(String string) {
        if (string == null || string.length() == 0) {
            return false;
        }
        for (int i = 0; i < string.length()/2; i++) {
            if (string.charAt(i) != string.charAt(string.length() - 1 - i)) {
                return false;
            }

        }
        return true;
    }
}