package com.example.leetcode.No215_kth_largest_element_in_an_array;

class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.findKthLargest(new int[]{3}, 1));
    }
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return foo(nums,0,nums.length-1,k);
    }

    public static int foo(int[] nums, int start, int end, int k) {
        int tmp = nums[start];
        int a = start;
        int b = end;
        while (start < end) {
            while (start < end && tmp <= nums[end]) {
                end--;
            }
            while (start < end && tmp >= nums[start]) {
                start++;
            }
            if (start < end) {
                int t = nums[end];
                nums[end] = nums[start];
                nums[start] = t;
            }
        }
        nums[a] = nums[start];
        nums[start] = tmp;
        //比tmp大的数的个数
        int i = nums.length - 1 - start +1;
        if (i == k) {
            return nums[start];
        }
        if (i < k) {
            //在左边
            return foo(nums, a, start-1, k);
        } else {
            return foo(nums, start + 1, b, k);
        }
    }


}