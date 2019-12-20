package com.example.leetcode.reverseinteger;

import cn.hutool.json.JSONUtil;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        System.out.println(-100/-1);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(-2147483641);
        System.out.println(reverse(-2147483641));
    }
    public static int reverse(int x) {
        boolean positive = false;
        if (x > 0) {
            positive = true;
        }
        int num = Math.abs(x);
        int shang = num;
        int yushu = 0;

        List<Integer> numList = new ArrayList<>();

        while (shang > 0) {
            yushu = shang%10;
            shang = shang/10;
            numList.add(yushu);
        }
        int result = 0;
        if (positive) {
            for (Integer integer : numList) {
                if (result != 0 && Integer.MAX_VALUE / result < 10) {
                    return 0;
                }
                if (Integer.MAX_VALUE - result * 10 < integer) {
                    return 0;
                }
                result = result * 10 + integer;
            }
        } else {

            for (Integer integer : numList) {
                if (result != 0 && Integer.MIN_VALUE / 10 > result) {
                    return 0;
                }
                if (Integer.MIN_VALUE - result * 10 > -integer) {
                    return 0;
                }
                result = result * 10 - integer;
            }
        }

        return result;

    }
}