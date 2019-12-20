package com.example.leetcode.No42_trappingrainwater;

class Solution {

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1}));
    }

    public static int trap(int[] height) {
        int topCount = 0;
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (max < height[i]) {
                max = height[i];
                topCount = 1;
            } else if (max == height[i]) {
                topCount++;
            }
        }

        int leftTop = 0;
        int rightTop = 0;
        int leftIdx = 0;
        int rightIdx = height.length -1;
        boolean leftStop = false;
        boolean rightStop = false;

        int result = 0;
        while (leftIdx <= rightIdx) {
            int leftNum = height[leftIdx];
            int rightNum = height[rightIdx];
            if (leftNum == max) {
                topCount--;
                if (topCount == 0 ) {
                    leftStop = true;
                }
            }
            if (rightNum == max) {
                topCount--;
                if (topCount == 0 ) {
                    rightStop = true;
                }
            }
            if (leftNum > leftTop) {
                leftTop = leftNum;
            } else if (leftNum < leftTop) {
                int diff = leftTop - leftNum;
                result +=diff;
            }

            if (rightNum > rightTop) {
                rightTop = rightNum;
            } else if (rightNum < rightTop) {
                int diff = rightTop - rightNum;
                result +=diff;
            }


            if (leftStop == false) {
                leftIdx++;
            }
            if (rightStop == false) {
                rightIdx--;
            }
        }

        return result;
    }
}