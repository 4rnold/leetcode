package com.example.leetcode.No322_coin_change;

import ch.qos.logback.classic.util.ContextInitializer;

import java.util.HashSet;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        [190,80,457,111,240]
//        6159
        System.out.println(solution.coinChange(new int[]{190,80,457,111,240}, 6159));
    }
    public int coinChange(int[] coins, int amount) {
        if (coins == null) {
            return -1;
        }
//        HashSet<Integer> coinSet = new HashSet<>();
//        for (int coin : coins) {
//            coinSet.add(coin);
//        }

        int[] count = new int[amount + 1];
        count[0] = 0;
        for (int i = 1; i < count.length; i++) {

            int min = Integer.MAX_VALUE;

            //不要遍历前面，遍历钱币
/*            for (int j = 0; j < i; j++) {
                if (count[j] == -1) {
                    continue;
                }
                int i1 = i - j;
                if (coinSet.contains(i1)) {
                    int tmp = count[j] + 1;
                    if (min > tmp) {
                        min = tmp;
                    }
                }
            }*/

            for (int j = 0; j < coins.length; j++) {
                int coin = coins[j];
                int i1 = i - coin;
                if (i1 >= 0) {
                    if (count[i1] != -1) {
                        int i2 = count[i1] + 1;
                        if (i2 < min) {
                            min = i2;
                        }
                    }
                }
            }

            if (min == Integer.MAX_VALUE) {
                count[i] = -1;
            } else {
                count[i] = min;
            }
        }

        return count[amount];
    }
}