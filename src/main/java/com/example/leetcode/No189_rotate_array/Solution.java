package com.example.leetcode.No189_rotate_array;

import cn.hutool.json.JSONUtil;

class Solution {
    public static void main(String[] args) {
        int[] a = {1};
        Solution solution = new Solution();
        solution.rotate(a, 5);
        System.out.println(JSONUtil.toJsonStr(a));
    }

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int tmp = 0;
        int count = 0;
        for (int i = 0; i < k; i++) {
            int idx = i;
            int a1 = nums[i];
            do {
                idx = (idx + k) % (nums.length);
                tmp = nums[idx];
                nums[idx] = a1;
                a1 = tmp;
                count++;
            } while (idx != i);

            if (count == nums.length) {
                break;
            }
        }
    }
}