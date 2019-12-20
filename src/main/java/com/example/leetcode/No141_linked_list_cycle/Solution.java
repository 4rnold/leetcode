package com.example.leetcode.No141_linked_list_cycle;

import com.example.leetcode.addtwonumbers.ListNode;

/**
 * Definition for singly-linked list.
 * class ListNode {
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
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode1;
        Solution solution = new Solution();
        System.out.println(solution.hasCycle(listNode1));
    }
    public boolean hasCycle(ListNode head) {
        ListNode a1 = head;
        ListNode a2 = head;
        int count = 1;
        while (a2 != null && a1 != null) {
            if (count % 2 == 0) {
                a2 = a2.next;
            }
            a1 = a1.next;
            if (a1 == a2) {
                return true;
            }
            count++;
        }
        return false;
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