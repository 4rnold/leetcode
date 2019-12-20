package com.example.leetcode.No206_reverse_linked_list;

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
        ListNode listNode = solution.reverseList2(listNode1);
        System.out.println();


//        ListNode listNode1 = new ListNode(1);
//        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(4);
//        ListNode listNode5 = new ListNode(5);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
//        Solution solution = new Solution();
//        ListNode lastNode = new ListNode(100);
//        solution.foo2(listNode1,lastNode);
//        System.out.println(lastNode.val);

    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode n1 = head;
        ListNode n2 = head.next;
        ListNode n3 = head.next != null ? head.next.next : null;
        n1.next = null;
        while (n2 != null) {

            n2.next = n1;

            n1 = n2;
            n2 = n3;
            if (n3 != null) {
                n3 = n3.next;
            }
        }
        return n1;

    }

    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return  null;
        }
        ListNode n1 = head;
        ListNode n2 = head.next;
        ListNode head2 = new ListNode(10);
//        ListNode head2 = null;

        foo3(n1, n2,head2);
        return head2.next;
    }

    public void foo(ListNode n1, ListNode n2, ListNode head) {
        ListNode tmp1 = n1;
        ListNode tmp2 = n2;
        if (tmp2 == null) {
            head = tmp1;
            return;
        }

        foo(tmp1.next, tmp2.next,head);
        tmp1.next = null;
        tmp2.next = tmp1;
    }

    public void foo3(ListNode n1, ListNode n2, ListNode head) {
        if (n2 == null) {
            head.next = n1;
            return;
        }

        foo3(n1.next, n2.next,head);
        n1.next = null;
        n2.next = n1;
    }


    public void foo2(ListNode node, ListNode lastNode) {
        if (node.next == null) {
            lastNode.next = node;
            return;
        }
        foo2(node.next, lastNode);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}