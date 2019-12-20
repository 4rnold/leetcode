package com.example.leetcode.No328_odd_even_linked_list;

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

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;


        Solution solution = new Solution();
        ListNode listNode = solution.oddEvenList(listNode1);
        System.out.println();
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode oddHead = head;
        ListNode oddTail = head;
        ListNode evenHead = head.next;
        ListNode evenTail = head.next;

        ListNode cursor = head;

        while (cursor != null) {
            int n = 2;
            while (n > 0 && cursor !=null) {
                cursor = cursor.next;
                n--;
            }


            if (cursor == null) {
                break;
            }

            oddTail.next = cursor;
            oddTail = cursor;
            evenTail.next = cursor.next;
            evenTail = cursor.next;
        }
        oddTail.next = evenHead;
        return oddHead;

    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}