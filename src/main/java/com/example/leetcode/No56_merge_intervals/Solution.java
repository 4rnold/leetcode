package com.example.leetcode.No56_merge_intervals;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//1,2,3,4,5 情况
class Solution {
    public static void main(String[] args) {
//        int[][] a = {{1,3},{2,6},{8,10},{15,18}};
        int[][] a = {{1, 4}, {4, 5}};
        System.out.println(JSONUtil.toJsonStr(merge(a)));
    }


    public static int[][] merge(int[][] intervals) {
        ArrayList<int[]> oldList = new ArrayList<>();

        for (int[] interval : intervals) {
            oldList.add(interval);
        }

        boolean hasMerge = true;
        ArrayList<int[]> tempList = new ArrayList<>();
        while (hasMerge) {
            hasMerge = false;
            //tempList = (ArrayList<int[]>) oldList.clone();
            tempList.clear();
            for (int[] anInt : oldList) {
                boolean localHasMerge = false;
                if (tempList.size() == 0) {
                    tempList.add(anInt);
                    continue;
                }
                Iterator<int[]> iterator = tempList.iterator();
                ArrayList<int[]> tempAdd = new ArrayList<>();

                while (iterator.hasNext()) {
                    int[] next = iterator.next();
                    int[] newItem = new int[2];
                    //没有交集就两种情况
                    if (anInt[1] < next[0] || anInt[0] > next[1]) {
                        newItem[0]= anInt[0];
                        newItem[1] = anInt[1];
                    } else {
                        //有交集
                        hasMerge = true;
                        localHasMerge = true;
                        newItem[0]= anInt[0] < next[0]? anInt[0]:next[0];
                        newItem[1] = anInt[1] > next[1]? anInt[1]:next[1];
                        iterator.remove();
                        tempAdd.add(newItem);
                    }
                }
                if (localHasMerge == false) {
                    tempAdd.add(anInt);
                }

                tempList.addAll(tempAdd);
            }
            oldList = (ArrayList<int[]>) tempList.clone();
        }
//        System.out.println(JSONUtil.toJsonStr(oldList));
        int[][] objects = new int[oldList.size()][2];

        for (int i = 0; i < oldList.size(); i++) {
            int[] ints = oldList.get(i);
            objects[i] = ints;
        }
        return objects;

    }
}