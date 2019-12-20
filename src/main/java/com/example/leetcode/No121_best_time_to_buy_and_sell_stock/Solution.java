package com.example.leetcode.No121_best_time_to_buy_and_sell_stock;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{1,2}));
    }

    public int maxProfit(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        int maxSpace = 0;
        for (int i = 0; i < prices.length; i++) {
            if (max < prices[i]) {
                max = prices[i];
            }
            if (min > prices[i]) {
                min = prices[i];
                //发现更小的，更新max
                max = 0;
            }
            int space = max - min;
            if (maxSpace < space) {
                maxSpace = space;
            }
        }
        return maxSpace;
    }
}