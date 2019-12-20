package com.example.leetcode.No76_minimum_window_substring;

import java.util.HashMap;
import java.util.Map;

class Solution2 {
    public static void main(String[] args) {

        //String a = "123456";
//        System.out.println(a.substring(0, ));

        System.out.println(minWindow("a", "aa"));

    }
    public static String minWindow(String s, String t) {
        //字符数量统计
        Map<Character, Integer> count = new HashMap<>();

        char[] tChars = t.toCharArray();
        for (char aChar : tChars) {
            if (count.containsKey(aChar)) {
                count.put(aChar,count.get(aChar) + 1);
            } else {
                count.put(aChar, 1);
            }
        }

        Map<Character, Integer> nowCount = new HashMap<>();
        for (Map.Entry<Character, Integer> characterIntegerEntry : count.entrySet()) {
            nowCount.put(characterIntegerEntry.getKey(), 0);
        }


        char[] sChars = s.toCharArray();

        int min = 0;
        int max = 0;
        int type = 1;

        String result = "";
        while (max < s.length()) {
            if (type == 1) {
                char sChar = sChars[max];
                if (nowCount.containsKey(sChar)) {
                    nowCount.put(sChar, nowCount.get(sChar) + 1);
                }
                //判断是否够了
                if (isEnough(count, nowCount)) {
                    type = 2;
                    continue;
                } else {
                    max++;
                }
            }

            if (type == 2) {
                char sChar = sChars[min];
                if (nowCount.containsKey(sChar)) {
                    //count--
                    Integer integer = nowCount.get(sChar);
                    if (integer - 1 >= count.get(sChar)) {
                        //没事，min继续加
                        nowCount.put(sChar,integer - 1);
                        min++;
                        continue;
                    } else {
                        String tempStr = s.substring(min, max + 1);
                        if (result.length() == 0) {
                            result = tempStr;
                        } else {
                            if (result.length() > tempStr.length()) {
                                result = tempStr;
                            }
                        }

                        max++;
                        type = 1;
                    }
                } else {
                    min++;
                }
                //判断是否
            }
        }



        return result;
    }

    public static boolean isEnough(Map<Character, Integer> count,Map<Character, Integer> nowCount ) {
        for (Map.Entry<Character, Integer> characterIntegerEntry : nowCount.entrySet()) {
            Integer integer = count.get(characterIntegerEntry.getKey());
            if (integer > characterIntegerEntry.getValue()) {
                return false;
            }
        }
        return true;
    }

}