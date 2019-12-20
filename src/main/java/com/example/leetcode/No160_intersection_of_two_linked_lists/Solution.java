package com.example.leetcode.No160_intersection_of_two_linked_lists;

import com.example.leetcode.addtwonumbers.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        listNode2.next = listNode4;

        Solution solution = new Solution();
        ListNode intersectionNode = solution.getIntersectionNode(listNode1, listNode2);
        System.out.println();

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        boolean p1Combine = false;
        boolean p2Combine = false;
        while (p1 != null && p2 != null) {
            if (p1 == p2) {
                return p1;
            }

            if (p1.next == null && p1Combine == false) {
                p1Combine = true;
                p1 = headB;
            } else {
                p1 = p1.next;
            }

            if (p2.next == null && p2Combine == false) {
                p2Combine = true;
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return null;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}