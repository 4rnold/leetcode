package com.example.leetcode.No118_pascals_triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        result.add(Arrays.asList(1));
//        if (numRows == 1)
//        result.add(Arrays.asList(1, 1));

        while (numRows > 1) {
            ArrayList<Integer> oneline = new ArrayList<>();
            oneline.add(1);

            List<Integer> preLine = result.get(result.size() - 1);
            for (int i = 0; i < preLine.size() -1; i++) {
                int i1 = preLine.get(i) + preLine.get(i + 1);
                oneline.add(i1);
            }
            oneline.add(1);
            result.add(oneline);
            numRows--;
        }
        return result;
    }
}