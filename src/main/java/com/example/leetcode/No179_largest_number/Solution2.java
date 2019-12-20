package com.example.leetcode.No179_largest_number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.largestNumber(new int[]{1440, 7548, 4240, 6616, 733, 4712, 883, 8, 9576}));
    }

    public String largestNumber(int[] nums) {
        ArrayList<Integer> integers = new ArrayList<Integer>();
        for (int num : nums) {
            integers.add(num);
        }

        Collections.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                Long a1 = Long.valueOf(String.valueOf(o1) + String.valueOf(o2));
                Long a2 = Long.valueOf(String.valueOf(o2) + String.valueOf(o1));

                if (a1 > a2) {
                    return -1;
                } else if (a1 < a2) {
                    return 1;
                } else
                    return 0;
            }
        });

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < integers.size(); i++) {
            Integer integer = integers.get(i);
            if (i == 0) {
                if (integer == 0) {
                    return "0";
                }
            }
            stringBuilder.append(integer);
        }

        return stringBuilder.toString();

    }
}
