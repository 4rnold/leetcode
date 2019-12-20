package com.example.leetcode.No283_move_zeroes;

import cn.hutool.json.JSONUtil;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = null;
        solution.moveZeroes(a);
        System.out.println(JSONUtil.toJsonStr(a));

    }
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int zeroIdx = 0;
        boolean tag = false;
        for (int numIdx = 0; numIdx < nums.length; numIdx++) {
            if (tag == false && nums[zeroIdx] == 0) {
                tag = true;
                zeroIdx = numIdx;
            }

            if (tag == false) {
                zeroIdx++;
            }
            if (nums[numIdx] != 0) {
                if (numIdx > zeroIdx) {
                    //交换
                    int tmp = nums[numIdx];
                    nums[numIdx] = nums[zeroIdx];
                    nums[zeroIdx] = tmp;
                    zeroIdx++;
                }
            }
        }
    }
}