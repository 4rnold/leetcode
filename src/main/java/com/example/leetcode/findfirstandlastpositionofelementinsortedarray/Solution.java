package com.example.leetcode.findfirstandlastpositionofelementinsortedarray;

import cn.hutool.json.JSONUtil;

class Solution {
    public static void main(String[] args) {
        System.out.println(JSONUtil.toJsonStr(searchRange(new int[]{10,10}, 10)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        int idx = -1;
        int minidx = -1;
        int maxidx = -1;

        while (start <= end) {
            int n = (start + end)/2;
            if (nums[n]> target) {
                end = n -1;
            } else if (nums[n] < target) {
                start = n+1;
            } else {
                minidx = n;
                maxidx = n;
                break;
            }
        }
        boolean tag1 = true;
        boolean tag2 = true;

        //向两边探索
        while (tag1||tag2) {
            int i = minidx - 1;
            if (i >= 0 && nums[i] == target) {
                minidx = i;
            } else {
                tag1 = false;
            }
            int i2 = maxidx + 1;
            if (i2 <= nums.length - 1 && nums[i2] == target) {
                maxidx = i2;
            } else {
                tag2 = false;
            }

        }

        return new int[]{minidx, maxidx};
    }
}