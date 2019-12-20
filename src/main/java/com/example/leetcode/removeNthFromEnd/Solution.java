package com.example.leetcode.removeNthFromEnd;


import cn.hutool.json.JSONUtil;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public static void main(String[] args) {

        ListNode listNode = removeNthFromEnd(bulidList(new int[]{1}), 1);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

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
    
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preDelNode = null;
        ListNode fixDelNode = null;
        ListNode a2 = head;
        int count = 0;//a2走了几步

        while (a2.next != null) {
            a2 = a2.next;
            count++;
            if (count == n - 2 && n -2 >= 0) {
                fixDelNode = head;
            }
            if (count > n - 2 && n-2 >=0 ) {
                if (fixDelNode == null) {
                    fixDelNode = head;
                }
                fixDelNode = fixDelNode.next;
            }
            if (count == n) {
                preDelNode = head;
            }
            if (count > n) {
//                if (preDelNode == null) {
//                    preDelNode = head;
//                }
                preDelNode = preDelNode.next;
            }

        }
        if (preDelNode == null) {
            return fixDelNode;
        } else {
            preDelNode.next = preDelNode.next.next;
        }

        //删除
        return head;

    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}


