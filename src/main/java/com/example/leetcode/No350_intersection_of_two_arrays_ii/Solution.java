package com.example.leetcode.No350_intersection_of_two_arrays_ii;

import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i : nums1) {
            integerIntegerHashMap.put(i, integerIntegerHashMap.getOrDefault(i, 0) + 1);
        }

        for (int i : nums2) {
            if (integerIntegerHashMap.containsKey(i)) {
                Integer integer = integerIntegerHashMap.get(i);
                if (integer > 0) {
                    result.add(i);
                    integerIntegerHashMap.put(i, integer - 1);
                }
            }
        }


        int[] ints = new int[result.size()];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = result.get(i);
        }

        //return result.toArray();
        return ints;
    }
}