package com.example.leetcode.No227_basic_calculator_ii;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {

 /*       LinkedList<Integer> objects = new LinkedList<>();
        objects.push(1);
        objects.push(2);
        Integer pop = objects.pop();
        System.out.println(pop);//2

        objects.push(2);
        objects.push(3);

        objects.add(4);
        Integer integer = objects.pollLast();
        System.out.println(integer);//4
        Integer integer1 = objects.pollLast();
        System.out.println(integer1);//1*/

        Solution solution = new Solution();
        System.out.println(solution.calculate(" 11 "));
    }


    public int calculate(String s) {
        if (s == null) {
            return 0;
        }
        s = s.replace(" ", "");
        LinkedList<Integer> nums = new LinkedList<>();
//        Stack<Integer> nums = new Stack<>();
        LinkedList<Character> sig = new LinkedList<>();
//        Stack<Character> sig = new Stack<>();
        Integer preNum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-'||c == '*' || c == '/') {
                nums.push(preNum);
                preNum = 0;
                if (sig.size()>0 && (sig.peek() == '*' || sig.peek() == '/')) {
                    Integer a2 = nums.pop();
                    Integer a1 = nums.pop();
                    Character op = sig.pop();
                    if (op == '*') {
                        int i1 = a1 * a2;
                        nums.push(i1);
                    }
                    if (op == '/') {
                        int i1 = a1 / a2;
                        nums.push(i1);
                    }
                }
                sig.push(c);

            } else if (c <= '9' && c >= '0') {
                preNum = preNum * 10 + Integer.parseInt(String.valueOf(c));
            }
        }
        nums.push(preNum);
        if (sig.size()> 0 && (sig.peek() == '*' || sig.peek() == '/')) {
            Integer a2 = nums.pop();
            Integer a1 = nums.pop();
            Character op = sig.pop();
            if (op == '*') {
                int i1 = a1 * a2;
                nums.push(i1);
            }
            if (op == '/') {
                int i1 = a1 / a2;
                nums.push(i1);
            }
        }

        while (sig.size() != 0) {
            Character c = sig.pollLast();
            Integer i1 = nums.pollLast();
            Integer i2 = nums.pollLast();
            if (c == '+') {
                int i = i1 + i2;
                nums.add(i);
            }
            if (c == '-') {
                int i = i1 - i2;
                nums.add(i);
            }
        }

        return nums.pop();

    }
}