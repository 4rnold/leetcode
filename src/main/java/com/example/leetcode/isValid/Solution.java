package com.example.leetcode.isValid;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {

        System.out.println(isValid(""));
    }
    public static boolean isValid(String s) {
        Stack<String> objects = new Stack<>();
        HashMap<String, String> left = new HashMap<>();

        left.put("{","}");
        left.put("(", ")");
        left.put("[","]");

        HashMap<String, String> right = new HashMap<>();

        right.put("}","{");
        right.put(")", "(");
        right.put("]","[");

        boolean result = true;

        for (char c : s.toCharArray()) {
            String s1 = String.valueOf(c);
            if (left.containsKey(s1)) {
                objects.push(s1);
            } else if (right.containsKey(s1)) {
                if (objects.isEmpty()) {
                    return false;
                }
                String pop = objects.pop();
                String o = right.get(s1);
                if (!o.equals(pop)) {
                    //result = false;
                    return false;
                }
            }
        }

        if (objects.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}