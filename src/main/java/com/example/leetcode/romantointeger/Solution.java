package com.example.leetcode.romantointeger;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.boot.autoconfigure.mustache.MustacheTemplateAvailabilityProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
    public static int romanToInt(String s) {

        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        System.out.println(map.containsKey('I'));

        HashMap<String, Integer> map2 = new HashMap<>();
        map2.put("IV", 4);
        map2.put("IX", 9);
        map2.put("XL", 40);
        map2.put("XC", 90);
        map2.put("CD", 400);
        map2.put("CM", 900);

        ArrayList<Integer> nums = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            int i = s.indexOf(entry.getKey());
            if (i >= 0) {
                s = s.replace(entry.getKey()," ");
                nums.add(entry.getValue());
            }
        }

        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            String s1 = String.valueOf(aChar);
            if (map.containsKey(s1)) {
                nums.add(map.get(s1));
            }
        }

        int result = 0;
        for (Integer num : nums) {
            result += num;
        }


        return result;
    }
}