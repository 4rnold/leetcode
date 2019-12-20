package com.example.leetcode.No204_count_primes;

import java.util.BitSet;

class Solution {
    public static void main(String[] args) {

//        BitSet bitSet = new BitSet();
//        bitSet.set(3);
//        bitSet.set(5);
//        bitSet.set(4);
//        String string = bitSet.toString();
//        BitSet bitSet1 = new BitSet();
//        bitSet1.set(3);
//        bitSet1.set(4);
//        System.out.println(bitSet.toString());
//        bitSet.and(bitSet1);
//        System.out.println(bitSet.toString());
//        System.out.println(bitSet.nextClearBit(3));
//
//        BitSet bitSet2 = new BitSet();
//        System.out.println(bitSet2.nextClearBit(10));

        Solution solution = new Solution();
        System.out.println(solution.countPrimes(11));
    }
    public int countPrimes(int n) {
        BitSet bitSet = new BitSet();
//        bitSet.set();
        double sqrt = Math.sqrt(n);
        bitSet.set(4);
        bitSet.set(6);
        bitSet.set(8);
        bitSet.set(9);
        for (int i = 2; i < sqrt; i++) {
            if (bitSet.get(i)) {

            }
            for (int j = 2; i*j < n; j++) {
                int i1 = i * j;
                bitSet.set(i1);
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            boolean b = bitSet.get(i);
            if (b == false) {
                count++;
            }
        }



        return count;
    }
}