package com.example.leetcode.containerwithmostwater;

class Solution {

    public static void main(String[] args) {
        int[] a = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(a));
    }


    public static int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;
        int max = 0;

        while (left < right) {
            if (leftMax > height[left]) {
                left++;
                continue;
            }

            if (leftMax < height[left]) {
                leftMax = height[left];
            }

            if (rightMax > height[right]) {
                right--;
                continue;
            }

            if (rightMax < height[right]) {
                rightMax = height[right];
            }


            //计算面积
            int i = right - left;
            int h = height[left] < height[right]?height[left]:height[right];
            int m = i * h;
            if (max < m) {
                max = m;
            }

            if (height[left] < height[right]) {
                left++;

            } else {
                right--;
            }
        }

        return max;
    }
}