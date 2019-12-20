package com.example.leetcode.No125_valid_palindrome;

import org.springframework.util.StringUtils;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
    }


    public boolean isPalindrome(String s) {
        String s1 = s.toLowerCase();
        char[] s2 = s1.toCharArray();
        int a = 0;
        int b = s2.length -1;
        while (a < b) {
            if (!(s2[a]>='a' && s2[a]<= 'z') && !(s2[a]>='0' && s2[a]<= '9')) {
                a++;
                continue;
            }

            if (!(s2[b]>='a' && s2[b]<= 'z') && !(s2[b]>='0' && s2[b]<= '9')) {
                b--;
                continue;
            }

            if (s2[a] != s2[b]) {
                return false;
            }
            a++;
            b--;
        }
        return true;
    }
}