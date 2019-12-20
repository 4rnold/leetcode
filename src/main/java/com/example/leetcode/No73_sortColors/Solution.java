package com.example.leetcode.No73_sortColors;

import cn.hutool.json.JSONUtil;

class Solution {
    public static void main(String[] args) {
        int[] a = {1,2,0};
        sortColors(a);
        System.out.println(JSONUtil.toJsonStr(a));

    }
    public static void sortColors(int[] nums) {
        int min = 0;
        int max = nums.length -1;

        for (int i = 0; i < nums.length; i++) {
            if (max < i) {
                break;
            }

            if (nums[i] == 0 ) {
                //交换
                if (i != min) {
                    int temp = nums[i];
                    nums[i] = nums[min];
                    nums[min] = temp;
                    i--;
                }
                min++;
            }

            if (nums[i] == 2 && max > i) {
                //交换
                int temp = nums[i];
                nums[i] = nums[max];
                nums[max] = temp;
                max--;
                i--;
            }
        }
    }
}