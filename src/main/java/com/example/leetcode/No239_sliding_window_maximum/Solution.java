package com.example.leetcode.No239_sliding_window_maximum;

import cn.hutool.json.JSONUtil;
import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

class Solution {
    static LinkedList<Integer> topN = new LinkedList<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(JSONUtil.toJsonStr(solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 1)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k ==0) {
            return new int[]{};
        }
        topN.clear();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                addTopN(nums[i]);
            } else {
                Integer max = topN.peekFirst();
                if (nums[i - k] == max) {
                    topN.pollFirst();
                }
                result.add(max);
                addTopN(nums[i]);
            }
        }
        result.add(topN.peekFirst());

        int[] ints = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ints[i] = result.get(i);
        }
        return ints;
    }

    public static void addTopN(Integer i) {
        while (true) {
            Integer last = topN.peekLast();
            if (last == null || last >= i) {
                topN.addLast(i);
                break;
            } else {
                topN.pollLast();
            }
        }
    }


}