package com.example.leetcode.No140_word_break_ii;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordBreak("aaaaaaaaaaaaaaaaaa", Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        int maxLength = 0;
        HashSet<String> wordSet = new HashSet<>();
        for (String s1 : wordDict) {
            if (s1.length() > maxLength) {
                maxLength = s1.length();
            }
            wordSet.add(s1);
        }
//        ArrayList<String> strings = new ArrayList<>();
//        HashSet<String> strings = new HashSet<>();
        //当前string 所对应的
        HashMap<String, List<List<String>>> map = new HashMap<>();
        map.put("", new ArrayList<>());
        HashMap<String, List<List<String>>> stageMap = new HashMap<>();
        ArrayList<String> removeList = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            stageMap.clear();
            removeList.clear();

            for (Map.Entry<String, List<List<String>>> stringListEntry : map.entrySet()) {
                String substring = s.substring(stringListEntry.getKey().length(), i + 1);
                if (substring.length() > maxLength) {
                    removeList.add(stringListEntry.getKey());
                }

                if (wordSet.contains(substring)) {
                    String key = s.substring(0, i + 1);
                    if (stringListEntry.getValue().size() == 0) {
                        ArrayList<String> objects = new ArrayList<>();
                        objects.add(substring);
                        addMapList(stageMap, key, objects);
                    } else {
                        for (List<String> strings : stringListEntry.getValue()) {
                            ArrayList<String> strings1 = new ArrayList<>(strings);
                            strings1.add(substring);
                            addMapList(stageMap, key, strings1);
                        }
                    }
                }
            }
//            for (String string : strings) {
//                String substring = s.substring(string.length(), i + 1);
//                if (wordSet.contains(substring)) {
//                    stage.add(string + substring);
//                }
//            }
            for (Map.Entry<String, List<List<String>>> stringListEntry : stageMap.entrySet()) {
                for (List<String> strings : stringListEntry.getValue()) {
                    addMapList(map,stringListEntry.getKey(),strings);
                }
            }
            for (String s1 : removeList) {
                map.remove(s1);
            }
        }


        for (Map.Entry<String, List<List<String>>> stringListEntry : map.entrySet()) {
            if (stringListEntry.getKey().length() == s.length()) {
                List<List<String>> value = stringListEntry.getValue();
                ArrayList<String> objects = new ArrayList<>();
                for (List<String> strings : value) {
                    String join = String.join(" ", strings);
                    objects.add(join);
                }
                return objects;
            }
        }
        return new ArrayList<>();
    }

    public static void addMapList(HashMap<String, List<List<String>>> map, String key, List<String> list) {

        if (map.containsKey(key)) {
            map.get(key).add(list);
        } else {
            ArrayList<List<String>> objects = new ArrayList<>();
            objects.add(list);
            map.put(key, objects);
        }
    }
}