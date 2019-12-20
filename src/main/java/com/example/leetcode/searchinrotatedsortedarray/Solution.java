package com.example.leetcode.searchinrotatedsortedarray;

class Solution {

    static int result = -1;

    public static void main(String[] args) {
        System.out.println(search(new int[]{5,3}, 5));
    }


    public static int search(int[] nums, int target) {
        result = -1;
        if (nums.length == 0) {
            return -1;
        }
        foo(nums, 0, nums.length - 1, target);
        return result;
    }

    public static void foo(int[] nums,int s,int e,int target) {

        if (result != -1) {
            return ;
        }
        int n = (s + e)/2;
        if (target == nums[n]) {
            result = n;
        } else {
            if (n -1 >= s && nums[s] <= nums[n]) {
                //左有序 = 右无序
                if (target < nums[n]) {
                    //小于中值,左右都有可能
                    if (s <= n - 1) {
                        foo(nums, s, n - 1, target);
                    }
                    if (n+1 <= e) {
                        foo(nums, n + 1, e, target);
                    }
                } else {
                    //右无序，大于n的在右边
                    if (n+1 <= e) {
                        foo(nums, n + 1, e, target);
                    }
                }

            } else {
                //左无序 = 右有序
                if (s <= n - 1 && target < nums[n]) {
                    //n在左
                    if (s <= n - 1) {
                        foo(nums, s, n - 1, target);
                    }
                } else {
                    //n在右
                    if (s <= n - 1){
                        foo(nums, s, n - 1, target);
                    }
                    if (n+1 <= e) {
                        foo(nums, n + 1, e, target);
                    }
                }

            }
        }
    }
}