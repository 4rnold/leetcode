//package com.example.leetcode.No179_largest_number;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.Comparator;
//
//class Solution {
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.largestNumber(new int[]{121,12}));
//    }
//
//
//    public String largestNumber(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return null;
//        }
//        //int[] clone = nums.clone();
//        ArrayList<Integer> integers = new ArrayList<Integer>();
//        for (int num : nums) {
//            integers.add(num);
//        }
//
//        Collections.sort(integers, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                String s1 = String.valueOf(o1);
//                String s2 = String.valueOf(o2);
//                boolean b = s1.length() > s2.length();
//                int length = b ? s2.length() : s1.length();
////                while (true) {
////                    char c = s1.charAt(idx);
////                }
////                for (int i = 0; i < length; i++) {
////                    int i1 = Integer.parseInt(String.valueOf(s1.charAt(i)));
////                    int i2 = Integer.parseInt(String.valueOf(s2.charAt(i)));
////                    if (i1 > i2) {
////                        return -1;
////                    } else if (i1 < i2) {
////                        return 1;
////                    }
////                }
//
//                //截取，比较
//                String substring1 = s1.substring(0, length);
//                String
//
//                if (s1.length() > length) {
//                    int i1 = Integer.parseInt(String.valueOf(s1.charAt(length)));
////                    for (int i = 0; i < s2.length(); i++) {
////                        int i2 = Integer.parseInt(String.valueOf(s2.charAt(i)));
////                        if (i1 > i2) {
////                            return -1;
////                        } else if (i1 < i2) {
////                            return 1;
////                        }
////                    }
//                    return 0;
////                    if (i1 > i2) {
////                        return -1;
////                    } else if (i1 < i2) {
////                        return 1;
////                    }
//                } else if (s2.length() > length) {
////                    int i1 = Integer.parseInt(String.valueOf(s1.charAt(0)));
//                    int i2 = Integer.parseInt(String.valueOf(s2.charAt(length)));
//                    for (int i = 0; i < s1.length(); i++) {
//                        int i1 = Integer.parseInt(String.valueOf(s1.charAt(i)));
//                        if (i1 > i2) {
//                            return -1;
//                        } else if (i1 < i2) {
//                            return 1;
//                        }
//                    }
//                    return 0;
////                    int i2 = Integer.parseInt(String.valueOf(s2.charAt(length)));
////                    if (i1 > i2) {
////                        return -1;
////                    } else if (i1 < i2) {
////                        return 1;
////                    }
//                } else {
//                    return 0;
//                }
////                return 0;
//            }
//        });
//
//        StringBuilder stringBuilder = new StringBuilder();
//
//        int count = 0;
//        for (Integer integer : integers) {
//            if (count == 0) {
//                if (integer == 0) {
//                    return "0";
//                }
//            }
//            stringBuilder.append(integer);
//            count++;
//        }
//
//
//        return stringBuilder.toString();
//    }
//
//}