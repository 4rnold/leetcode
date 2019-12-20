package com.example.leetcode.No55_jump_game;

class Solution {

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{0}));
    }

    public static boolean canJump(int[] nums) {
//        if (nums.length == 1) {
//            return true;
//        }


        for (int i = 0; i < nums.length -1; i++) {
            if (nums[i] == 0) {
                boolean canJump = false;
                for (int j = 1; j <= i; j++) {
                    int num = nums[i - j];
                    if (num > j) {
                        canJump = true;
                        break;
                    }
                }
                if (canJump == false) {
                    return false;
                }
            }
        }
        return true;
    }
}