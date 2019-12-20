package com.example.leetcode.No202_happy_number;

import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isHappy(19));
    }
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        Integer result = 0;
        while (result != 1) {
            result = 0;
            while (n != 0) {
                int i = n % 10;
                n = n/10;
                result += i*i;
            }
            if (set.contains(result)) {
                return false;
            } else {
                set.add(result);
                n = result;
            }
        }
        return true;
    }
}