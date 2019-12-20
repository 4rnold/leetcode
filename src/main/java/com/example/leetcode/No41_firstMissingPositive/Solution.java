package com.example.leetcode.No41_firstMissingPositive;

class Solution {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1,1,1}));
    }
    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > 0 && num < nums.length && num != i +1 && nums[num -1] != num) {
                int temp = nums[num-1];
                nums[num-1] = num;
                nums[i] = temp;
                i--;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                return i +1;
            }
        }
        return nums.length + 1;
    }
}