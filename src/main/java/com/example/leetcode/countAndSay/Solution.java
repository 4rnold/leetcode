package com.example.leetcode.countAndSay;

import java.util.ArrayList;
import java.util.StringJoiner;

class Solution {
    public static void main(String[] args) {
        System.out.println(countAndSay(2));
    }


    public static String countAndSay(int n) {
//        char[] result = {'1'};
        ArrayList<String> result = new ArrayList<>();
        result.add("1");

        while (n > 1) {
            String temp = "";
            int count = 0;
            ArrayList<String> tempList = new ArrayList<>();
            String last = "";
            for (int i = 0; i < result.size(); i++) {
                last = result.get(i);
                if (i == 0) {
                    temp = result.get(i);
                    count = 0;
                }

                if (!last.equals(temp)) {
                    //重置计数器
                    tempList.add(String.valueOf(count));
                    tempList.add(temp);
                    temp = last;
                    count = 1;
                    if (i == result.size()-1) {
                        tempList.add(String.valueOf(count));
                        tempList.add(temp);
                    }
                } else {
                    count++;
                    if (i == result.size()-1) {
                        tempList.add(String.valueOf(count));
                        tempList.add(temp);
                    }
                }
            }

            result = tempList;
            n--;
        }

        return String.join("", result);
    }
}