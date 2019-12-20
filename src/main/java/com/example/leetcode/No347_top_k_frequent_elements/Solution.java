package com.example.leetcode.No347_top_k_frequent_elements;

import java.util.*;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {


        HashMap<Integer, Integer> integerMap = new HashMap<>();


        for (int num : nums) {
            if (integerMap.containsKey(num)) {
                integerMap.put(num, integerMap.get(num) + 1);
            } else {
                integerMap.put(num, 1);
            }
        }

        PriorityQueue<Integer> objects = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return integerMap.get(o2) - integerMap.get(o1);
            }
        });
        objects.addAll(integerMap.keySet());
        ArrayList<Integer> res = new ArrayList<>();

        while (k > 0) {
            res.add(objects.poll());
            k--;
        }
        return res;
    }
}