package com.example.leetcode.No46_permutations;

import java.util.*;

class Solution {
    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2}));
    }
    public static List<List<Integer>> permute(int[] nums) {
        result.clear();
        HashSet<Integer> numbers = new HashSet<>();
        for (int num : nums) {
            numbers.add(num);
        }
        foo(numbers, "");
        return result;

    }

    public static void foo(HashSet<Integer> numbers, String listStr) {
        if (numbers.size() == 0) {
            String[] split = listStr.split(":");
            ArrayList<Integer> objects = new ArrayList<>();
            for (String s : split) {
                objects.add(Integer.valueOf(s));
            }

            result.add(objects);
            return;
        }

        for (Integer number : numbers) {
            String tempStr = listStr + number + ":";
//            listStr += number + ":";
            HashSet<Integer> clone = (HashSet<Integer>) numbers.clone();
            clone.remove(number);
            foo(clone, tempStr);
        }

//        Iterator<Integer> iterator = numbers.iterator();
//        while (iterator.hasNext()) {
//            Integer next = iterator.next();
//
//        }
    }
}