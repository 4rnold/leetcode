//package com.example.leetcode.No78_subsets;
//
//import java.util.*;
//
//
//class Solution {
//
//    public static void main(String[] args) {
//        System.out.println(1<<3);
////        System.out.println(subsets(new int[]{1,2}));
//    }
//
//    public static List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        result.add(new ArrayList<>());
//        for (int i = 0; i < nums.length; i++) {
//            int n = i + 1;
//            //固定后面几个
//
//            //第几个数
//            int m = 1;
//            while (m <= n) {
//                int start = m;
//                int end = nums.length - 1 - (n - m);
//                ArrayList<Integer> fixHeadTail = new ArrayList<>();
//                //先加固定的头，再加固定的尾，再遍历中间
//                for (int j = 0; j < start - 1; j++) {
//                    fixHeadTail.add(nums[j]);
//                }
//                for (int j = end + 1; j < nums.length; j++) {
//                    fixHeadTail.add(nums[j]);
//                }
//                //中间
//                if (m > 1) {
//                    end--;
//                }
//                for (int j = start - 1; j < end + 1; j++) {
//                    ArrayList<Integer> integers = new ArrayList<>();
//                    integers.addAll(fixHeadTail);
//                    integers.add(nums[j]);
//                    result.add(integers);
//                }
//                m++;
//            }
//        }
//        return result;
//    }
//
////    public static void foo2(int[] nums, int n, int startIdx)
//
////    public static void foo(Set<Integer> nums, int n, Set<Integer> container) {
////        if (n == 1) {
////            Iterator<Integer> iterator = nums.iterator();
////            while (iterator.hasNext()) {
////                ArrayList<Integer> objects = new ArrayList<>();
////                objects.addAll(container);
////                objects.add(iterator.next());
////                result.add(objects);
////            }
//////            for (int i = 0; i < nums.size(); i++) {
//////                ArrayList<Integer> objects = new ArrayList<>();
//////                objects.addAll(container);
//////                objects.add(nums.);
//////                result.add(objects);
////////                if (!container.contains(nums[i])) {
////////                    ArrayList<Integer> objects = new ArrayList<>();
////////                    objects.addAll(container);
////////                    objects.add(nums[i]);
////////                    result.add(objects);
////////                }
//////            }
////        } else {
////            for (int i = 0; i < nums.length; i++) {
////                if (!container.contains(nums[i])) {
////                    HashSet<Integer> container2 = new HashSet<>();
////                    container2.addAll(container);
////                    container2.add(nums[i]);
////                    int nn = n - 1;
////                    foo(nums, nn, container2);
////                }
////            }
////        }
////    }
////    public static void foo(Set<Integer> nums, int n, Set<Integer> container) {
////        if (n == 1) {
////            for (int i = 0; i < nums.length; i++) {
////                if (!container.contains(nums[i])) {
////                    ArrayList<Integer> objects = new ArrayList<>();
////                    objects.addAll(container);
////                    objects.add(nums[i]);
////                    result.add(objects);
////                }
////            }
////        } else {
////            for (int i = 0; i < nums.length; i++) {
////                if (!container.contains(nums[i])) {
////                    HashSet<Integer> container2 = new HashSet<>();
////                    container2.addAll(container);
////                    container2.add(nums[i]);
////                    int nn = n -1;
////                    foo(nums,nn,container2);
////                }
////            }
////        }
////    }
//}