//package com.example.leetcode.No148_sortList;
//
//import com.example.leetcode.addtwonumbers.ListNode;
//
///**
// * Definition for singly-linked list.
// * public class ListNode {
// * int val;
// * ListNode next;
// * ListNode(int x) { val = x; }
// * }
// */
//class Solution {
//    public ListNode sortList(ListNode head) {
//        int mergeCount = 1;
//        ListNode pre = head;
//        ListNode a = head;
//        ListNode b = head;
//        while (true) {
//            int c = mergeCount;
//            //找b
//            while (c >0) {
//                if (b == null) {
//                    break;
//                }
//                b = b.next;
//                c--;
//            }
//
//            int aCount = mergeCount;
//            int bCount = mergeCount;
//            while (aCount > 0 || bCount > 0) {
//                if (a.val < b.val) {
//                    pre.next = a;
//                    aCount--;
//                    if (aCount != 0) {
//                        //==0就不移动了，始终指向a的最后一个
//                        a = a.next;
//                    }
//                } else {
//                    pre.next = b;
//                    bCount--;
//                }
//                if (aCount <= 0) {
//                    a.next = b;
//                    while (bCount > 0) {
//                        b = b.next;
//                    }
//                }
//            }
//
//
//            mergeCount *=2;
//        }
//
//    }
//
//    static class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode(int x) {
//            val = x;
//        }
//    }
//}