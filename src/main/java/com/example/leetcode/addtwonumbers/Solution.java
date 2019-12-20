//package com.example.leetcode.addtwonumbers;
//
//import java.util.LinkedList;
//
///**
// * Definition for singly-linked list.
// * public class ListNode {
// *     int val;
// *     ListNode next;
// *     ListNode(int x) { val = x; }
// * }
// */
//public class Solution {
//    public static void main(String[] args) {
//
//    }
//
//    public ListNode buildData(int[] a) {
//        ListNode listNode = new ListNode(a[0]);
//        for (int i = 1; i < a.length; i++) {
//            listNode.next =
//        }
//    }
//
//
//
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode temp1 = l1;
//        double num1 = 0;
//        double count = 0;
//        while (temp1!=null) {
//            double val = temp1.val;
//            double pow = Math.pow(10, count);
//            num1 += (double) (val * pow);
//            count++;
//            temp1 = temp1.next;
//        }
//
//        ListNode temp2 = l2;
//        double num2 = 0;
//        count = 0;
//        while (temp2!=null) {
//            double val = temp2.val;
//            double pow = Math.pow(10, count);
//            num2 += (double) (val * pow);
//            count++;
//            temp2 = temp2.next;
//        }
//
//        double i = num1 + num2;
//        System.out.println(i);
//        double result = i / 10;
//        double residue = i % 10;
//
//        ListNode firstlistNode = new ListNode((int) residue);
//        ListNode preNode = firstlistNode;
//
//        while (result > 0) {
//            residue = result % 10;
//            result = result / 10;
//            ListNode currentNode = new ListNode((int) residue);
//            preNode.next = currentNode;
//            preNode = currentNode;
//        }
//
//
//        return firstlistNode;
//    }
//}
//
//class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int x) { val = x; }
//}