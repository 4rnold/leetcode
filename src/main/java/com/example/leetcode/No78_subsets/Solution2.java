package com.example.leetcode.No78_subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1}));
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int num : nums) {
            ArrayList<List<Integer>> objects = new ArrayList<>();
            for (List<Integer> integers : result) {
                ArrayList<Integer> item = new ArrayList<>(integers);
                item.add(num);
                objects.add(item);
            }

            result.addAll(objects);
        }

        return result;

    }
}
