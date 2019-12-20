package com.example.leetcode.No234_palindrome_linked_list;

import com.example.leetcode.addtwonumbers.ListNode;

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

        ListNode node = new ListNode(1);
//        ListNode node2 = new ListNode(1);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(2);
//        ListNode node5 = new ListNode(1);
//        node.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;

        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(node));
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        int count = 0;
        ListNode fastNode = head;
        ListNode first = head;
        ListNode second = head;
        ListNode last = head;

        while (fastNode.next != null) {

            int n = 2;
            while (n > 0 && fastNode.next != null) {
                count++;
                fastNode = fastNode.next;
                n--;
            }

//            if (fastNode.next == null) {
//                break;
//            }

            ListNode pFirst = first;
            first = first.next;

            if (count > 2) {
                second = pFirst;
                //反转
                second.next = last;
                last = second;

            }
        }


        ListNode l2 = null;
        ListNode l1 = second;

        if (count % 2 == 1) {
            //基数
            //比较 first 和 l2
            l2 = first;
        } else {
//            ListNode l2 = first.next;
            //比较 second 和 l2;
            l2 = first.next;
        }

        //比较
        while (l2 != null && l1!=null) {
            if (l2.val != l1.val) {
                return false;
            } else {
                l2 = l2.next;
                l1 = l1.next;
            }
        }

        return true;

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}