package com.example.leetcode.threeSum;

import cn.hutool.json.JSONUtil;

import java.lang.reflect.Array;
import java.util.*;

class Solution {

    public static Set<String> cache = new HashSet<>();

    public static void main(String[] args) {

//        int[] a = new int[]{5,-11,-7,-2,4,9,4,4,-5,12,12,-14,-5,3,-3,-2,-6,3,3,-9,4,-13,6,2,11,12,10,-14,-15,11,0,5,8,0,10,-11,-6,-1,0,4,-4,-3,5,-2,-15,9,11,-13,-2,-8,-7,9,-6,7,-11,12,4,14,6,-4,3,-9,-14,-12,-2,3,-8,7,-13,7,-12,-9,11,0,4,12,-6,-7,14,-1,0,14,-6,1,6,-2,-9,-4,-11,12,-1,-1,10,-7,-6,-7,11,1,-15,6,-15,-12,12,12,3,1,9,12,9,0,-11,-14,-1};
        int[] a = new int[]{-1,-12,14,-6,4,-11,2,-7,13,-15,-1,11,-15,-15,13,-9,-11,-10,-7,-13,7,9,-13,-3,10,1,-5,12,11,-9,2,-4,-6,-7,5,5,-2,14,13,-12,14,-3,14,14,-11,5,12,-6,10,-9,-4,-6,-15,-9,-1,2,-1,9,-9,-5,-15,8,-2,-6,9,10,7,14,9,5,-13,9,-12,8,8,-8,-2,-2,1,-15,-4,5,-13,-4,3,1,5,-13,-13,11,-11,10,5,3,11,-9,-2,3,-10,-7,-6,14,9,-11,7,2,-4,13,7,5,13,-12,-13,7,-9,5,-7,11,-1,-12,8,3,13,-10,13,1,-4};
//        int[] a = new int[]{-1,0,1,2,-1,-4};


        System.out.println(threeSum(a));
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        cache.clear();
        ArrayList<Integer> numList = new ArrayList<>();

        for (int num : nums) {
            numList.add(num);
        }

        Collections.sort(numList);

        int a = 0;
        int b = 1;
        int c = 2;


//        Map<String, List<Integer>> result = new HashMap();
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (numList.size() < 3) {
            return new ArrayList<>();
        }

        foo(a, b, c, numList, result);

        ArrayList<List<Integer>> objects = new ArrayList<>();

//        for (Map.Entry<String, List<Integer>> stringListEntry : result.entrySet()) {
//            objects.add(stringListEntry.getValue());
//        }

//        System.out.println(JSONUtil.toJsonStr(result));
        for (List<Integer> integers : result) {

        }

        return result;
    }

    public static void foo(int idx1, int idx2, int idx3, List<Integer> numList, List<List<Integer>> result) {
//        if (idx1 >= idx2) {
//            return;
//        }
//        if (idx2 >= idx3) {
//            return;
//        }


        String key = idx1 + ":" + idx2 + ":" + idx3;
//        if (cache.contains(key)) {
//            return;
//        } else {
//        System.out.println(key);
            cache.add(key);
        System.out.println(key);
//        }
//        if (numList.get(idx1) > 0 ) {
//            return;
//        }
        if (numList.get(idx3) >= 0) {
            Integer sum = numList.get(idx1) + numList.get(idx2) + numList.get(idx3);
            if (sum == 0) {
                ArrayList<Integer> objects = new ArrayList<>();
                objects.add(numList.get(idx1));
                objects.add(numList.get(idx2));
                objects.add(numList.get(idx3));
                //System.out.println(idx1 + ":" + idx2 + ":" + idx3);
//                String idx = numList.get(idx1) + ":" + numList.get(idx2) + ":" + numList.get(idx3);
//                if (!result.containsKey(idx)) {
//                    result.put(idx, objects);
//                }
                result.add(objects);

                return;
            }
            if (sum > 0) {
                return;
            }
        }

        int tempidx1 = idx1 + 1;
//        if (tempidx1 == idx2) {
//            return;
//        }
//        if (tempidx1 == idx3) {
//            return;
//        }
        if (tempidx1 < idx2 && numList.get(tempidx1) <= 0 && numList.get(idx3) >= 0) {

            String key1 = tempidx1 + ":" + idx2 + ":" + idx3;
            if (!cache.contains(key1)) {
                foo(tempidx1, idx2, idx3, numList, result);
            }
        }

        int tempidx2 = idx2 + 1;

//        if (tempidx2 >= idx3) {
//            return;
//        }
        if (tempidx2 < idx3 && numList.get(idx1) <= 0 && numList.get(idx3) >= 0) {
            String key1 = idx1 + ":" + tempidx2 + ":" + idx3;
            if (!cache.contains(key1)) {
                foo(idx1, tempidx2, idx3, numList, result);
            }
        }


        int tempidx3 = idx3 + 1;
//        if (tempidx3 == idx2) {
//            return;
//        }
        if (tempidx3 > idx2 && tempidx3 < numList.size() && numList.get(idx1) <= 0 ) {
            String key1 = idx1 + ":" + idx2 + ":" + tempidx3;
            if (!cache.contains(key1)) {
                foo(idx1, idx2, tempidx3, numList, result);
            }
        }
    }
}