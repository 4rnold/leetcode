package com.example.leetcode.No152_maximum_product_subarray;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProduct(new int[]{3,-1,4}));
    }
    public int maxProduct(int[] nums) {
        ArrayList<int[]> ints = new ArrayList<>();
        ArrayList<Integer> count = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        //a按0分割
        int start = 0;
        int negCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negCount++;
            }
            if (nums[i] == 0) {
                max = 0;
                int[] ints1 = Arrays.copyOfRange(nums, start, i);
                if (ints1.length > 0) {
                    ints.add(ints1);
                    count.add(negCount);
                }
                negCount= 0;
                start = i+1;
            } else if (i == nums.length - 1) {
                int[] ints1 = Arrays.copyOfRange(nums, start, nums.length);
                ints.add(ints1);
                count.add(negCount);
                negCount= 0;
            }
        }


        for (int i = 0; i < ints.size(); i++) {
            if (count.get(i) % 2 == 0) {
                //计算乘积
                int r = 1;
                int[] ints1 = ints.get(i);
                for (int i1 : ints1) {
                    r = r * i1;
                }
                if (r > max) {
                    max = r;
                }
            } else if (count.get(i) == 1) {
                int[] ints1 = ints.get(i);
                if (ints1.length == 1) {
                    if (max < ints1[0]) {
                        max = ints1[0];
                    }
                } else {
                    int p = 1;
                    for (int j = 0; j < ints1.length; j++) {
                        int i1 = ints1[j];
                        if (i1 < 0) {
                            if (p > max) {
                                max = p;
                            }
                            p = 1;
                        } else {
                            p = p * i1;
                            if (j == ints1.length-1) {
                                if (p > max) {
                                    max = p;
                                }
                            }
                        }
                    }
                }
            } else {
                //从两边找负数
                int[] ints1 = ints.get(i);
                boolean left = true;
                boolean right = true;
                for (int j = 0; j < ints1.length; j++) {
                    if (left == true && ints1[j] < 0) {
                        //找到左边的
                        int p = 1;
                        for (int k = j+1; k < ints1.length; k++) {
                            p = p * ints1[k];
                        }
                        if (p > max) {
                            max = p;
                        }
                        left = false;
                    }
                    if (right == true && ints1[ints1.length - 1 - j]<0) {
                        //找到右边的
                        int p = 1;
                        for (int k = ints1.length - 1 - j-1; k >= 0; k--) {
                            p = p * ints1[k];
                        }
                        if (p > max) {
                            max = p;
                        }
                        right = false;
                    }
                }
            }
        }

        return max;
    }
}