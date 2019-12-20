package com.example.leetcode.twosum;

import cn.hutool.json.JSONUtil;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        int[] a = {3,3};
        int t = 6;
        System.out.println(JSONUtil.toJsonStr(twoSum(a,t)));



    }



    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            int re = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == re) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}