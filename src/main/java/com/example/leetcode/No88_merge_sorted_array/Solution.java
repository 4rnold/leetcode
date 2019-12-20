package com.example.leetcode.No88_merge_sorted_array;

import cn.hutool.json.JSONUtil;

class Solution {

    public static void main(String[] args) {
//        int[] a = {1, 2, 3, 0, 0, 0};
//        merge(a, 3, new int[]{2,5,6}, 3);
//[0]
//        0
//                [1]
//        1
        int[] a = {0};
        merge(a, 0, new int[]{1},1);

        System.out.println(JSONUtil.toJsonStr(a));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m + n - 1;

        int p1 = m -1;
        int p2 = n-1;

        while (p2 >= 0) {

            if (p1>=0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }
    }
}