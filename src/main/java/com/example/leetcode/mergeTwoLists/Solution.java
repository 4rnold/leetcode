package com.example.leetcode.mergeTwoLists;

import cn.hutool.json.JSONUtil;
import com.example.leetcode.addtwonumbers.ListNode;
import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public static void main(String[] args) {
        ListNode a1 = bulidList(new int[]{});
        ListNode a2 = bulidList(new int[]{});

//        ListNode a1 = bulidList(new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE});
//        ListNode a2 = bulidList(new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE});


        ListNode listNode = mergeTwoLists(a1, a2);

        System.out.println(JSONUtil.toJsonStr(listNode));

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



    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode a1 = l1;
        ListNode a2 = l2;

        ListNode head = new ListNode(0);
        ListNode tail = head;
        int val1 = Integer.MAX_VALUE;
        int val2 = Integer.MAX_VALUE;

        while (a1 != null || a2 != null) {
            if (a1 != null) {
                val1 = a1.val;
            } else {
                val1 = Integer.MAX_VALUE;
            }
            if (a2 != null) {
                val2 = a2.val;
            } else {
                val2 = Integer.MAX_VALUE;
            }

            if (val1 < val2) {
                ListNode listNode = new ListNode(val1);
                tail.next = listNode;
                tail = listNode;
                if (a1 != null) {
                    a1 = a1.next;
                } else {
                    a2 =a2.next;
                }
            } else {
                ListNode listNode = new ListNode(val2);
                tail.next = listNode;
                tail = listNode;
                if (a2 != null) {
                    a2 = a2.next;
                } else {
                    a1 = a1.next;
                }
            }

        }

        return head.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}