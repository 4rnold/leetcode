package com.example.leetcode.addtwonumbers;

import cn.hutool.json.JSONUtil;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution12 {
    public static void main(String[] args) {
        ListNode listNode = bulidList(new int[]{5});
        ListNode listNode2 = bulidList(new int[]{5});
        ListNode listNode1 = addTwoNumbers(listNode, listNode2);



        System.out.println(JSONUtil.toJsonStr(listNode1));

    }

    public static ListNode bulidList(int[] a) {
        ListNode firstNode = new ListNode(0);
        ListNode preNode = new ListNode(0);
        for (int i = 0; i < a.length; i++) {
            ListNode listNode = new ListNode(a[i]);

            if (i == 0) {
                firstNode = listNode;
                preNode = listNode;
            } else {
                preNode.next = listNode;
                preNode = listNode;
            }
        }

        return firstNode;
    }



    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode temp1 = l1;
        ListNode temp2 = l2;

        ListNode firstNode = new ListNode(0);
        ListNode preNode = new ListNode(0);

        int jinwei = 0;
        int count = 1;

        while (temp1 != null || temp2 != null || jinwei != 0) {

            int val1  = 0;
            int val2 = 0;

            if (temp1 != null) {
                val1 = temp1.val;
            }
            if (temp2 != null) {
                val2 = temp2.val;
            }

            int sum = val1 + val2 + jinwei;
            jinwei = sum / 10 ;
            int yushu = sum % 10;
            ListNode current = new ListNode(yushu);
            if (count == 1) {
                firstNode = current;
                preNode = current;
            } else {
                preNode.next = current;
                preNode = current;
            }
            if (temp1 != null) {
                temp1 = temp1.next;
            }
            if (temp2 != null) {
                temp2 = temp2.next;
            }
            count++;
        }


        return firstNode;
    }
}

//class ListNode implements Serializable {
//    int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//}