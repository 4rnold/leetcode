package com.example.leetcode.No84_largest_rectangle_in_histogram;

import cn.hutool.json.JSONUtil;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
//        int[] a = {1, 2, 3, 4, 5};
//        int[] ints = Arrays.copyOfRange(a, 0, 0);
//        System.out.println(JSONUtil.toJsonStr(ints));

        System.out.println(largestRectangleArea(new int[]{}));
    }


    static int maxSpace = 0;
    public static int largestRectangleArea(int[] heights) {
        maxSpace = 0;
        foo(heights);
        return maxSpace;
    }

    public static void foo(int[] heights) {
        //找最小
        int minH = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < heights.length; i++) {
            if (minH >= heights[i]) {
                minH = heights[i];
                minIdx = i;
            }
        }

        if (minIdx == -1) {
            return ;
        }

        //算面积
        int space = heights.length * minH;
        if (maxSpace < space) {
            maxSpace = space;
        }
        //构造数组
        int[] left = Arrays.copyOfRange(heights, 0, minIdx);
        int[] right = Arrays.copyOfRange(heights, minIdx + 1, heights.length);
        foo(left);
        foo(right);
    }
}