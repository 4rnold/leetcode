package com.example.leetcode.generateParenthesis;

import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

class Solution {

    static List<String> result = new ArrayList<>();
    public static void main(String[] args) {
//        Stack<String> objects = new Stack<>();
//        objects.push("1");
//        Stack clone = (Stack) objects.clone();
//        System.out.println(11);

        List<String> strings = generateParenthesis(3);
        System.out.println(JSONUtil.toJsonStr(strings));
    }


    public static List<String> generateParenthesis(int n) {
        result.clear();
        int left = n;
        int right = n;

        Stack<String> stack = new Stack<>();
        String string = "";
        foo(stack, string, left, right, 1);

        return result;
    }

    public static void foo(Stack<String> stack,String string, int left, int right, int type) {
        Stack<String> cloneStack = (Stack<String>) stack.clone();

        if (type == 1) {
            //放（
            cloneStack.push("(");
            string += "(";
            left--;
            if (left > 0) {
                foo(cloneStack, string, left, right, 1);
            }
            if (right > 0) {
                foo(cloneStack, string, left, right, 2);
            }
        } else {
            if (cloneStack.size() > 0) {
                String peek = cloneStack.peek();
                if (peek.equals("(")) {
                    //可以放
                    cloneStack.pop();
                    string += ")";
                    right--;
                    if (left > 0) {
                        foo(cloneStack, string, left, right, 1);
                    }
                    if (right > 0) {
                        foo(cloneStack, string, left, right, 2);
                    }

                } else {
                    return;
                }
            } else {
                return;
            }
        }
        if (left == 0 && right == 0) {
            result.add(string);
            return;
        }
    }

}