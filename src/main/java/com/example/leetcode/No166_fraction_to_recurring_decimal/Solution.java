package com.example.leetcode.No166_fraction_to_recurring_decimal;

import org.springframework.format.number.money.CurrencyUnitFormatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

class Solution {
    public static void main(String[] args) {
//        Integer a = Integer.MIN_VALUE;
//        int abs = Math.abs(-100);
//        System.out.println(abs);

        Solution solution = new Solution();
        System.out.println(solution.fractionToDecimal(-2147483648, 1));
    }
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            return null;
        }
        int sig = 1;
        if ((long)numerator * (long) denominator < 0L) {
            sig = -1;
        }
        long numerator2 = Math.abs((long) numerator);
        long denominator2 = Math.abs((long) denominator);

        long zhengshu = numerator2/denominator2;
        long yushu = numerator2%denominator2;
        Long circleStartNum = null;

        //保留商
        ArrayList<Long> integers = new ArrayList<>();
        //余数对应的第几位
        HashMap<Long, Long> yunshuMap = new HashMap<>();
        long count = 0;
        while (yushu!=0) {
            long i = yushu * 10;
            long shang = i / (long) denominator2;
            yushu = i% (long)denominator2;
            if (yunshuMap.containsKey(yushu)) {
                //有了
//                yunshuMap.put(yushu, count);
                integers.add(shang);
                circleStartNum = yushu;
                break;
            } else {
                if (yushu != 0) {
                    yunshuMap.put(yushu,count);
                }
                integers.add(shang);
            }
            count++;
        }
        String result = String.valueOf(zhengshu);

        if (circleStartNum == null) {
            //没有循环
            for (int i = 0; i < integers.size(); i++) {
                if (i == 0) {
                    result += ".";
                }
                result += integers.get(i);
            }
        } else {
            //第几
            long integer = yunshuMap.get(circleStartNum);
            for (int i = 0; i < integers.size(); i++) {
                if (i == 0) {
                    result += ".";
                }
                if (integer+1 == i) {
                    result += "(";
                }
                long integer1 = integers.get(i);
//                if (integer1 < 0) {
//                    integer1 = Math.abs(integer1);
//                }
                result += integer1;
                if (i == integers.size() - 1) {
                    result += ")";
                }
            }
        }
        if (sig < 0) {
            return "-" + result;
        } else {
            return result;
        }
//        return result;
    }
}