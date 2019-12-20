package com.example.leetcode.threeSum;

import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
//        int[] a = new int[]{-1,-12,14,-6,4,-11,2,-7,13,-15,-1,11,-15,-15,13,-9,-11,-10,-7,-13,7,9,-13,-3,10,1,-5,12,11,-9,2,-4,-6,-7,5,5,-2,14,13,-12,14,-3,14,14,-11,5,12,-6,10,-9,-4,-6,-15,-9,-1,2,-1,9,-9,-5,-15,8,-2,-6,9,10,7,14,9,5,-13,9,-12,8,8,-8,-2,-2,1,-15,-4,5,-13,-4,3,1,5,-13,-13,11,-11,10,5,3,11,-9,-2,3,-10,-7,-6,14,9,-11,7,2,-4,13,7,5,13,-12,-13,7,-9,5,-7,11,-1,-12,8,3,13,-10,13,1,-4};
        int[] a = new int[]{-6,-8,-9,4,-14,6,-10,7,12,13,4,9,7,14,-12,7,0,14,-1,-3,2,2,-3,11,-6,-10,-13,-13,1,-9,2,2,-2,8,-9,0,-9,-12,14,10,8,3,4,0,-6,7,14,9,6,-2,13,-15,8,-5,3,-13,-8,5,-11,0,11,6,-13,-14,-9,-15,-7,-11,10,-7,14,4,3,3,11,13,-13,11,-1,0,-6,-10,0,9,0,10,11,0,0,-14,-15,-12,-1,10,12,-2,2,-10,2,-2,-10,2,-13,1,12,5,-1,-15,1,5,-8,3,10,8};
        System.out.println(threeSum(a));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        //排序
        ArrayList<Integer> numList = new ArrayList<>();

        for (int num : nums) {
            numList.add(num);
        }

        Collections.sort(numList);
        if (numList.size() < 3) {
            return new ArrayList<>();
        }


        HashMap<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < numList.size(); i++) {
            int a = numList.get(i);
            if (a > 0) {
                break;
            }
            int idx1 = i+ 1;
            int idx2 = numList.size() -1;
            while (true) {
                if (idx2 < idx1) {
                    break;
                }
                if (numList.get(idx2) < 0) {
//                    idx2--;
                    break;
                } else {
                    System.out.println(idx1 + ":" + idx2);
                    int sum = numList.get(idx1) + numList.get(idx2) + a;
                    if (sum > 0) {
                        idx2--;
                    } else if (sum == 0) {
                        ArrayList<Integer> objects = new ArrayList<>();
                        objects.add(a);
                        objects.add(numList.get(idx1));
                        objects.add(numList.get(idx2));
                        String key = a + ":"+ numList.get(idx1) + ":" + numList.get(idx2);
                        map.put(key, objects);
                        idx1++;
                        idx2--;
                        //break;
                    } else if (sum < 0) {
                        idx1++;
                    }
                }
            }
        }

        ArrayList<List<Integer>> objects = new ArrayList<>();

        for (Map.Entry<String, List<Integer>> stringListEntry : map.entrySet()) {
            objects.add(stringListEntry.getValue());
        }
        return objects;

    }
}
