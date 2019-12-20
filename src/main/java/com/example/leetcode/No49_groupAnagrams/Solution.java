package com.example.leetcode.No49_groupAnagrams;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            List<String> charList = new ArrayList<>();
            for (char aChar : chars) {
                charList.add(String.valueOf(aChar));
            }
            Collections.sort(charList);
            String join = String.join("", charList);
            if (map.containsKey(join)) {
                map.get(join).add(str);
            } else {
                ArrayList<String> objects = new ArrayList<>();
                objects.add(str);
                map.put(join, objects);
            }
        }
        ArrayList<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> stringListEntry : map.entrySet()) {
            List<String> value = stringListEntry.getValue();
            result.add(value);
        }
        return result;
    }
}