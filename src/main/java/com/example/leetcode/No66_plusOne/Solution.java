package com.example.leetcode.No66_plusOne;

import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        System.out.println(JSONUtil.toJsonStr(plusOne(new int[]{9})));
    }
    public static int[] plusOne(int[] digits) {
        List<Integer> result = new ArrayList<>();
        int more = 0;

        for (int i = digits.length -1; i >= 0 ; i--) {
            int plus = digits[i] + more;
            if (i == digits.length -1) {
                plus++;
            }
            more = plus / 10;
            int i2 = plus % 10;
            result.add(i2);
            //digits[i] = i2;
        }

        if (more > 0) {
            result.add(more);
        }

        int[] r = new int[result.size()];
        //倒序
        int idx = 0;
        for (int i = 0; i < result.size(); i++) {
            idx = result.size() -1 -i;
            r[idx] = result.get(i);
        }
        return r;
    }
}