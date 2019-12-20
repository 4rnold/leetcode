package com.example.leetcode.No134_gas_station;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{1,2,3,4,5}));
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int start = 0; start < gas.length; start++) {
            int g = gas[start];
            int n = start;
            while (g > 0) {
                int c = cost[n];
                g = g - c;
                if (g < 0) {
                    break;
                }
                n = (n + 1) % (gas.length);
                g += gas[n];
                if (n == start) {
                    return start;
                }
            }
        }
        return -1;
    }
}