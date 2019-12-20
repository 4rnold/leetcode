package com.example.leetcode.No122_best_time_to_buy_and_sell_stock2;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{}));
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int max = 0;
        int min = Integer.MAX_VALUE;
        int maxSpace = 0;
        int oneTimeMax = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                min = prices[i];
            }
            if (max <= prices[i]) {
                max = prices[i];
            } else {
                int i1 = max - min;
                maxSpace += i1;
                min = prices[i];
                max = prices[i];

            }
        }
        maxSpace += max - min;
        return maxSpace;
    }
}