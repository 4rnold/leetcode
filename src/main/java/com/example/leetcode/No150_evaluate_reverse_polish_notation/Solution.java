package com.example.leetcode.No150_evaluate_reverse_polish_notation;

import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> objects = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                Integer b = objects.pop();
                Integer a = objects.pop();
                objects.push(a + b);
            } else if (token.equals("-")) {
                Integer b = objects.pop();
                Integer a = objects.pop();
                objects.push(a - b);
            }else if (token.equals("*")) {
                Integer b = objects.pop();
                Integer a = objects.pop();
                objects.push(a * b);
            }else if (token.equals("/")) {
                Integer b = objects.pop();
                Integer a = objects.pop();
                objects.push(a / b);
            } else {
                objects.push(Integer.parseInt(token));
            }
        }
        Integer peek = objects.peek();
        return peek;
    }
}